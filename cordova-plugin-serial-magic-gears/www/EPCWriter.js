/// <reference path="/js/config.js" />
/// <reference path="/js/helpers.js" />

var exec = require("cordova/exec");
rfidScanner = {

	writeEpc: function (epc, onSuccess, onFailure) {
		exec(onSuccess, onFailure, "EPCWriter", "writeEPC", [epc]);
	}
}