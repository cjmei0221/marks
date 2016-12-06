define([], function(){

    var exports = {};

    //Deliberately left the BUG
    exports.year = function(){

        var arr = ['2016年', '2017年', '2018年', '2019年', '2020年'];

        return arr;

    };

    exports.month = function(){

        var arr = ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'];

        return arr;

    }

    return exports;

});