/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *使用最频繁通用的方法
 **/
"use strict";





/**
 *调用某个url参数
 *使用方法:
 *GetQueryString(name)
 **/
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null)
        return unescape(r[2]);
    return null; //返回参数值
}
function GetQueryStringByEncode(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null)
        return unescape(decodeURI(r[2]));
    return null; //返回参数值
}
/**
 *调用某个url参数
 *使用方法:
 *GetQueryString(name)
 **/
function setQueryString(data) {
    var params = "";
    if (isnotnull(data) && (typeof (data) == "object" && Object.keys(data).length > 0)) {
        params += "?";
        var num = 0;
        for (var x in data) {
            num++;
            params += x + "=" + data[x];
            if (num < Object.keys(data).length) {
                params += "&";
            }
        }
    }
    return params; //返回参数值
}


//long转时间戳
function timeFormat(time) {
    var date = new Date(time);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var Hours = date.getHours();
    var Minutes = date.getMinutes();
    month = month < 10 ? "0" + month : month;
    day = day < 10 ? "0" + day : day;
    Hours = Hours < 10 ? "0" + Hours : Hours;
    Minutes = Minutes < 10 ? "0" + Minutes : Minutes;
    return year + "-" + month + "-" + day + " " + Hours + ":" + Minutes;
}


function timeFormatYYMMDD(time) {
    var date = new Date(time);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    month = month < 10 ? "0" + month : month;
    day = day < 10 ? "0" + day : day;
    return year + "-" + month + "-" + day;
}

function timeFormatYYMMDDChina(time) {
    var date = new Date(time);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    return year + "年" + month + "月" + day + "日";
}
function timeFormatYYMMDDChinaDate(date) {
    var date = new Date(date);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    return year + "年" + month + "月" + day + "日";
}

//循环生成
String.prototype.format = function () {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length === 1 && typeof (arguments[0]) === "object") {
            var argsObj = arguments[0];
            for (var key in argsObj) {
                if (argsObj[key] !== undefined) {
                    if ("object" != typeof (argsObj[key])) {
                        var reg = new RegExp("({" + key + "})", "g");
                        var value = argsObj[key];
                        if ("number" == typeof (argsObj[key]) && argsObj[key] > 1000000000) {
                            value = timeFormat(argsObj[key]);
                        }
                        result = result.replace(reg, value);
                    } else {
                        for (var x in argsObj[key]) {
                            var reg = new RegExp("({)" + key + "." + x + "(})", "g");
                            var value = argsObj[key][x];
                            if ("number" == typeof (argsObj[key][x]) && argsObj[key][x] > 1000000000) {
                                value = timeFormat(argsObj[key][x]);
                            }
                            result = result.replace(reg, value);
                        }
                    }
                }
            }
        } else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] !== undefined) {
                    if ("object" != typeof (arguments[i])) {
                        var reg = new RegExp("({)" + i + "(})", "g");
                        var value = arguments[i];
                        if ("number" == typeof (arguments[i]) && arguments[i] > 1000000000) {
                            value = timeFormat(arguments[i]);
                        }
                        result = result.replace(reg, value);
                    } else {
                        for (var x in arguments[i]) {
                            var reg = new RegExp("({)" + i + "." + x + "(})", "g");
                            var value = arguments[i][x];
                            if ("number" == typeof (arguments[i][x]) && arguments[i][x] > 1000000000) {
                                value = timeFormat(arguments[i][x]);
                            }
                            result = result.replace(reg, value);
                        }
                    }

                }
            }
        }
    }
    return result;
};

/**
 *进行参数不为空判断
 **/
function isnotnull(data) {
    if ("" == data || "undefined" == data || "null" == data || null == data || typeof data == "undefined") {
        return false;
    }
    return true;
}

//获取离当前的n天的日期
function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount); //获取AddDayCount天后的日期 
    var year = dd.getFullYear();
    var month = dd.getMonth() + 1 < 10 ? "0" + (dd.getMonth() + 1) : dd.getMonth() + 1;
    var day = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate();
    return year + "-" + month + "-" + day;
}




