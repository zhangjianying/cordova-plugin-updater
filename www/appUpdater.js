var exec = require('cordova/exec');

var appUpdater ={
	downloadInstallAPK:function(url,success,error){
		exec(success, error, "AppUpdater", "downloadInstallAPK", [url]);
	},
}
module.exports = appUpdater;