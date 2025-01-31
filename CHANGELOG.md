# Changelog

## [1.13](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.13) - 2023-06-29

* The speed (in meters per second) is now included in all messages.
* Fixed a bug where the MQTT toggle switch was not displaying when MDM override was enabled.

## [1.12.2](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.12.2) - 2023-03-28

* Changed the color of the MQTT protocol stream status light on the Dashboard.
* Fixed a bug where the MDM configured stream settings were not being reflected on the Dashboard.

## [1.12.1](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.12.1) - 2023-03-13

* Fixed a Bluetooth Permissions bug.
* Exclude the Google Protobuf Audit library.

## [1.12](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.12) - 2023-03-04

* Remove the use of the GMS library for CDR location.
* Fixed some bugs that resulted in the app crashing.

## [1.11](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.11) - 2023-02-27

* Adds support for logging Call Detail Record (CDR) events to a CSV file.
* Caches the Bluetooth UI results so the results are still visible when switching between tabs.
* Adds a connection toggle switch and direct link to the MQTT Connection Fragment from the Dashboard.
* Changes the default location provider to Fused, which should improve battery life.

## [1.10.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.10.0) - 2023-01-24

* Sets the mdmOverride field on the device status message instead of using firebase analytics
  events.
* Adds a Dashboard UI for toggling logging to files as well as viewing the MQTT connection status.

## [1.9.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.9.0) - 2022-10-28

* Library updates, permission updates, logging updates, and other minor changes.

## [1.8.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.8.0) - 2022-09-26

* Empty GNSS survey messages are now sent when GNSS survey is turned on and no GNSS satellites are
  observed. This is to indicate that the device is surveying as expected, but no satellites are
  visible.

## [1.7.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.7.0) - 2022-07-03

* Scan QR Code for configuring the MQTT Broker connection information. (
  Thanks [dtufekcic](https://github.com/dtufekcic)!)

## [1.6.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.6.0) - 2021-12-18

* The WiFi UI is saved when swapping between fragments, so you don’t have to wait for the next scan
  to see something.
* The Cellular UI got a total overhaul, and now displays all protocols (except CDMA) and all
  neighbor cells as well.
* Updated to compile against Android 12.

## [1.5.1](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.5.1) - 2021-11-30

* Fixed a bug where incorrect 5G NR values were being reported.
* Updated to NS Messaging API version 0.8.0.
* Added support for setting the EcNo field for UMTS.

## [1.5.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.5.0) - 2021-09-13

* Added support for 5G New Radio (NR) survey.
* Added the AGC to the GNSS Status Display.
* Added a location accuracy field to each message (both GeoPackage and MQTT).

## [1.4.3](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.4.3) - 2021-08-08

* Fixed several bugs that could cause the app to crash in various scenarios.

## [1.4.2](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.4.2) - 2021-07-08

* Fixed a bug where the survey record queue would fill up and reject new records.
* Added the missionId and recordNumber fields to the Phone State message.
* Added support for logging the Phone State message to GeoPackage.

## [1.4.1](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.4.1) - 2021-06-28

* Fixed a bug where the MQTT connection would not reconnect when the phone dropped its data
  connection.

## [1.4.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.4.0) - 2021-06-11

* Fixed a bug where permissions were not being requested on Android 11.
* Added support for streaming Phone State messages out over MQTT. The Phone State message is used to
  report some basic information about the phone such as the current serving cell, current
  technology, if a SIM is present, etc.
* Updated the default Bluetooth scan interval to 30 seconds because I kept seeing messages that the
  previous scan was not done when using 15 and 20 seconds as defaults.
* Updated the default GNSS scan interval to 10 seconds since 8 seconds seemed too often.
* Added a Device Model field to the GNSS and Device Status messages.
* Added the Mission ID field to the GeoPackage files.
* Improved the UX for error scenarios when connecting to an MQTT broker (e.g. notify the user of
  invalid username/password).
* Fixed the GNSS Raw Measurements information link.

## [1.3.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.3.0) - 2021-05-18

* Updated the permissions dialog with some extra details on why the background location is needed.

## [1.2.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.2.0) - 2021-04-29

* Improved the MQTT Connection stability and fixed a few bugs that resulted in the app crashing.

## [1.1.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.1.0) - 2021-04-15

* Added support for streaming a Device Status message over an MQTT connection.
* Fixed the logging buttons on the toolbar so that they are always visible.

## [1.0.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v1.0.0) - 2021-01-20

* Added Bluetooth survey support for streaming over an MQTT connection and logging to a GeoPackage
  file.
* Added a Bluetooth survey UI for viewing all Bluetooth devices within range.
* Updated the Wi-Fi Status UI to reflect when Wi-Fi is disabled.

## [0.4.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.4.0) - 2020-11-17

* Fixed a bug that caused an app crash if it was opened, hidden, and reopened in short sequence.
* Fixed a bug where the app would crash if trying to enable GNSS logging with location services
  turned off.
* Added a survey log file rollover option to prevent the log file from growing too large.
* Added support for streaming GNSS records over an MQTT connection.
* Added a dialog to warn the user if the device does not support raw GNSS measurements.
* Added several more app restrictions to allow more control when the device is under MDM.

## [0.3.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.3.0) - 2020-10-01

* Reduced the GNSS GeoPackage file size by around 100x.
* Changed the GNSS GeoPackage table format.
* Added scan rate interval user preferences for Cellular, Wi-Fi, and GNSS.

## [0.2.1](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.2.1) - 2020-08-21

* Updated the device time field to use RFC 3339 instead of Unix Epoch time.
* Fixed a bug where the connection would not stop if the server shutdown before the client.

## [0.2.0](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.2.0) - 2020-08-11

* Updated to use the new Network Survey Messaging connection library.
* Updated to use the new Network Survey Messaging format for the MQTT messages.

## [0.1.5](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.1.5) - 2020-07-02

* Fixed a bug where the MDM override setting was not being saved.

## [0.1.4](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.1.4) - 2020-07-02

* Changed the TLS Enabled MDM setting from a string to a boolean.

## [0.1.3](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.1.3) - 2020-06-30

* Added the user entered device name to the outgoing MQTT messages.
* When the MQTT connection is configured via MDM, the configuration is now displayed in the MQTT
  connection UI.
* Added a user preference to auto start the MQTT connection when the phone is booted.

## [0.1.2](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.1.2) - 2020-06-03

* Wi-Fi beacon survey records can now be logged to a GeoPackage file, and sent over the connections.
* Added support for displaying the list of visible Wi-Fi networks.
* Improved the stability of the MQTT connection.
* The app's version number is now displayed in the navigation drawer.

## [0.1.1](https://github.com/christianrowlands/android-network-survey/releases/tag/v0.1.1) - 2020-05-08

* Added support for connecting to an MQTT broker and streaming cellular survey records.
* Added support for allowing the MQTT broker connection information to be set via MDM.
* Fixed a bug that caused the calculator text field to be covered on screens with low resolution and
  large font.

## [0.1.0](https://github.com/christianrowlands/android-network-survey/releases/tag/release-0.1.0) - 2020-03-24

* Added support for logging GNSS information to a GeoPackage file.

## [0.0.9](https://github.com/christianrowlands/android-network-survey/releases/tag/release-0.0.9) - 2020-01-10

* Moved the file logging and connection logic to foreground services to prevent the Android System
  from stopping them.
* The connection now supports sending GSM, CDMA, UMTS, and LTE survey records.
* Added a navigation drawer and put the calculators and connection in it.
* Added a settings UI.
* Other general improvements.
