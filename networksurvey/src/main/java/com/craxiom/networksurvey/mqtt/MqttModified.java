package com.craxiom.networksurvey.mqtt;

import com.amazonaws.services.iot.client.AWSIotConnectionStatus;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.craxiom.messaging.*;
import com.craxiom.mqttlibrary.IConnectionStateListener;
import com.craxiom.mqttlibrary.connection.BrokerConnectionInfo;
import com.craxiom.mqttlibrary.connection.ConnectionState;
import com.craxiom.networksurvey.listeners.*;
import com.craxiom.networksurvey.model.WifiRecordWrapper;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import timber.log.Timber;

import java.util.ArrayList;
import java.util.List;

public class MqttConnection implements ICellularSurveyRecordListener, IWifiSurveyRecordListener,
        IBluetoothSurveyRecordListener, IGnssSurveyRecordListener, IDeviceStatusListener {

    private static final String MQTT_TOPIC_PREFIX = "networksurvey";
    private static final String MQTT_GSM_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/gsm";
    private static final String MQTT_CDMA_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/cdma";
    private static final String MQTT_UMTS_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/umts";
    private static final String MQTT_LTE_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/lte";
    private static final String MQTT_NR_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/nr";
    private static final String MQTT_WIFI_BEACON_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/80211_beacon";
    private static final String MQTT_BLUETOOTH_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/bluetooth";
    private static final String MQTT_GNSS_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/gnss";
    private static final String MQTT_DEVICE_STATUS_MESSAGE_TOPIC = MQTT_TOPIC_PREFIX + "/device_status";

    private String AWS_ACCESS_KEY_ID;
    private String AWS_SECRET_ACCESS_KEY;

    private String mqttClientId = "mqttclientId";
    private AWSIotMqttClient client;

    private final JsonFormat.Printer jsonFormatter;
    private final List<IConnectionStateListener> listeners = new ArrayList<>();

    public MqttConnection() {
        loadAWSCredentials();
        jsonFormatter = JsonFormat.printer().preservingProtoFieldNames().omittingInsignificantWhitespace();
    }

    private void loadAWSCredentials() {
        this.AWS_ACCESS_KEY_ID = System.getProperty("AWS_ACCESS_KEY_ID");
        this.AWS_SECRET_ACCESS_KEY = System.getProperty("AWS_SECRET_ACCESS_KEY");
    }

    public ConnectionState getConnectionState() {
        if (client.getConnectionStatus() == AWSIotConnectionStatus.CONNECTED) {
            return ConnectionState.CONNECTED;
        } else {
            return ConnectionState.DISCONNECTED;
        }
    }

    public void connect(BrokerConnectionInfo connectionInfo) {
        int maxRetries = 3;
        int retryCount = 0;
        while (retryCount < maxRetries) {
            try {
                if (client == null) {
                    this.client = new AWSIotMqttClient(connectionInfo.getMqttBrokerHost(),
                            connectionInfo.getMqttClientId(), AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);
                }
                this.client.connect();
                notifyConnectionStateChange(ConnectionState.CONNECTED);
                break;
            } catch (AWSIotException e) {
                Timber.e(e, "Failed to connect to AWS IoT Core. Attempt " + (retryCount + 1));
                retryCount++;
                if (retryCount == maxRetries) {
                    Timber.e("Max retry attempts reached. Giving up.");
                }
            }
        }
    }

    public void disconnect() {
        try {
            this.client.disconnect();
            notifyConnectionStateChange(ConnectionState.DISCONNECTED);
        } catch (AWSIotException e) {
            Timber.e(e, "Failed to disconnect from AWS IoT Core");
        }
    }

    public void registerMqttConnectionStateListener(IConnectionStateListener connectionStateListener) {
        listeners.add(connectionStateListener);
    }

    public void unregisterMqttConnectionStateListener(IConnectionStateListener connectionStateListener) {
        listeners.remove(connectionStateListener);
    }

    private void notifyConnectionStateChange(ConnectionState newState) {
        for (IConnectionStateListener listener : listeners) {
            listener.onConnectionStateChanged(newState);
        }
    }

    protected void publishMessage(String mqttMessageTopic, MessageOrBuilder message) {
        try {
            final String messageJson = jsonFormatter.print(message);
            Timber.d("Publishing to topic " + mqttMessageTopic + " message " + messageJson);

            if (client != null) {
                client.publish(mqttMessageTopic, messageJson);
            }
        } catch (Exception e) {
            Timber.e(e, "Caught an exception when trying to send an MQTT message");
        }
    }

    @Override
    public void onGsmSurveyRecord(GsmRecord gsmRecord) {
        if (mqttClientId != null) {
            final GsmRecord.Builder recordBuilder = gsmRecord.toBuilder();
            gsmRecord = recordBuilder.setData(recordBuilder.getDataBuilder().setDeviceName(mqttClientId)).build();
        }
        publishMessage(MQTT_GSM_MESSAGE_TOPIC, gsmRecord);
    }

    @Override
    public void onCdmaSurveyRecord(CdmaRecord cdmaRecord) {
        if (mqttClientId != null) {
            final CdmaRecord.Builder recordBuilder = cdmaRecord.toBuilder();
            cdmaRecord = recordBuilder.setData(recordBuilder.getDataBuilder().setDeviceName(mqttClientId)).build();
        }
        publishMessage(MQTT_CDMA_MESSAGE_TOPIC, cdmaRecord);
    }

    @Override
    public void onUmtsSurveyRecord(UmtsRecord umtsRecord) {
        if (mqttClientId != null) {
           
