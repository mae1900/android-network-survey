package com.craxiom.networksurvey.constants;

/**
 * Some constants used in the Network Survey App.
 *
 * @since 0.0.4
 */
public class NetworkSurveyConstants
{
    private NetworkSurveyConstants()
    {
    }

    public static final int DEFAULT_GRPC_PORT = 2621;

    public static final String NOTIFICATION_CHANNEL_ID = "network_survey_notification";
    public static final int CONNECTION_NOTIFICATION_ID = 3;
    public static final int LOGGING_NOTIFICATION_ID = 1;

    public static final String GPRS = "GRPS";
    public static final String EDGE = "EDGE";
    public static final String UMTS = "UMTS";
    public static final String CDMA = "CDMA";
    public static final String EVDO_0 = "EVDO 0";
    public static final String EVDO_A = "EVDO A";
    public static final String RTT1x = "CDMA - 1xRTT";
    public static final String HSDPA = "HSDPA";
    public static final String HSUPA = "HSUPA";
    public static final String HSPA = "HSPA";
    public static final String IDEN = "IDEN";
    public static final String EVDO_B = "EVDO B";
    public static final String LTE = "LTE";
    public static final String EHRPD = "CDMA - eHRPD";
    public static final String HSPAP = "HSPA+";
    public static final String GSM = "GSM";
    public static final String TD_SCDMA = "TD-SCDMA";
    public static final String IWLAN = "IWLAN";
    public static final String LTE_CA = "LTE-CA";
    public static final String NR = "NR";

    // Properties
    public static final String PROPERTY_AUTO_START_CELLULAR_LOGGING_KEY = "autoStartLogging";
    public static final String PROPERTY_AUTO_START_GNSS_LOGGING_KEY = "autoStartGnssLogging";
    public static final String PROPERTY_CONNECTION_TIMEOUT_KEY = "connectionTimeout";
}
