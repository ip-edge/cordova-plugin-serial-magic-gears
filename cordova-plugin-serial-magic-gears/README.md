# cordova-plugin-serial-magic-gears
Cordova plugin for SerialMagic Gears RFID writing app
Created by [iP Edge](https://www.ipedge.net/). 

Used to write EPC RFID tags on Android using SerialMagic Gears.

## Description: 
This plugin is used to write RFID Epcs using SerialMagic Gears, and [Serialio](https://serialio.com/) Scanfobs. 
As SerialMagic Gears is only available on Android, this plugin will only work for Android. 
Serialio Scanfob is required.
 

## Installation via CLI: 
To install SerialMagic Gears EPC Writer you must enter the directory of the Cordova project and run:
```
cordova plugin add cordova-plugin-serial-magic-gears 
```

## Alternative Installation:
The plugin can be added to the Cordova projects config.xml, linking the source to the git repository

## Usage: 
Call serialMagicGears.writeEpc() while passing through the EPC for the tag you wish to write to. 
eg:
```javascript
serialMagicGears.writeEpc(epcTag, yourOnSuccessFunction(), yourOnFailureFunction());
```

## Legal
This plugin or iP Edge is not endorsed or affiliated with [SerialMagic Gears](https://serialio.com/product/keystroke-simulation-wedge/serialmagic-gears-android), nor does it claim any ownership over trademarks.
iP Edge provides no warranty for this plugin-use at your own risk! 