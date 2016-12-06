//========浏览器本地缓存=========
define([],function(){

    var exports = {};

    //json字符串转成 json对象
    var toJson = function(data){
      if (typeof data == "string") {
          //用try...catch判断data是否为json字符串,否则return false;
          try {
            return JSON.parse(data);
          } catch (e) {
            console.warn("storage.js--toJson");
            return false;
          }
      }else{
            return data
      }
    }

    //json对象转成 json字符串
    var toJsonStr = function(data){
      if (typeof data == "object") {
          //用try...catch判断data是否为json对象,否则return false;
          try {
            return JSON.stringify(data);
          } catch (e) {
            console.warn("storage.js--toJsonStr");
            return false;
          }
      }else{
            return data
      }
    }

    /**
     * [浏览器本地缓存的唯一key值]
     * 命名规则: 商户名_字段名
     * 商户名缩写如下:
     * 蒙牛---MN
     * 多美滋---DMZ
     * 雅士利---YSL
     */
    exports.keys = {
        MN_getIntegral : 'MN_getIntegral',//会员积分信息提交
    }

    exports.setSessionStorage = function(key,value){
        if (!key) {console.warn("storage.js--setSessionStorage--key is undefined");return false;}
        var value_str = toJsonStr(value);
        if (value_str!==false) {
            sessionStorage.setItem(key,value_str);
            return true;
        }
    }

    exports.getSessionStorage = function(key){
        if (!key) {console.warn("storage.js--getSessionStorage--key is undefined");return false;}
        var value_str = sessionStorage.getItem(key);
        return toJson(value_str);//如果是json字符串类型,转为对象类型
    }

    return exports;
})