define([], function(){

    var exports = {};

    exports.mobile = function(val){
        var reg =/^1\d{10}$/;
        return reg.test(val);
    }

    return exports;

});