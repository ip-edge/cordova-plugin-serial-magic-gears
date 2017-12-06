# cordova-plugin-serial-magic-gears
Cordova plugin for SerialMagic Gears RFID writing app v:0.1.0

Created by iP Edge. 

Used to write EPC rfid tags on android using SerialMagic Gears.

Description: 

This plugin is used to write RFID Epcs using SerialMagic Gears, and Serialio Scanfobs. 
It is only available for Android

Installation: 

Add the plugin to the cordova project, and use cordova.exec() while passing through the EPC you want write. 

Eg. cordova.exec(epcRfid, onSuccessFunction(), onFailureFunction());  



