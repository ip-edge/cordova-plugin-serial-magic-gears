/// <reference path="/js/config.js" />
/// <reference path="/js/helpers.js" />

var exec = require("cordova/exec");
var serialMagicGears = {

	writeEpc: function (epc, onSuccess, onFailure) {
		exec(onSuccess, onFailure, "EPCWriter", "writeEPC", [epc]);
	}
};