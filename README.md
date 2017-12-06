# cordova-plugin-serial-magic-gears
Cordova plugin for SerialMagic Gears RFID writing app v:0.1.0

Created by iP Edge. 

Used to write EPC rfid tags on android using SerialMagic Gears.

Description: 
This plugin is used to write RFID Epcs using SerialMagic Gears, and Serialio Scanfobs. 
It is only available for Android

Installation:
Install via CLI: 
cordova-plugin add cordova-plugin-serial-magic-gears 

Usage: 
Use cordova.exec() while passing through the EPC you want write. 
Eg. cordova.exec(epcRfid, onSuccessFunction(), onFailureFunction());  




