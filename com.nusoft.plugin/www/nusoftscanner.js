/*global cordova, module*/

module.exports = {
    scan: function (success) {
        cordova.exec(success, function() {}, "NusoftScanner", "scan", "");
    }
};
