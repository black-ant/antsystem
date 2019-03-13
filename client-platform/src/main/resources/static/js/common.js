/**
 * 公共工具类
 * @type {{storegeeditutil: comutils.storegeeditutil, setQueryString: (function(*=): string), GetQueryStringByEncode: comutils.GetQueryStringByEncode}}
 */
var params = {
    url : "http://localhost:2101/"
}
var comutils = {
    storegeeditutil: function (name, value, option) {
        if (arguments.length == 1) {
            return window.localStorage.getItem(name);
        } else if (arguments.length == 2) {
            window.localStorage.setItem(name, value);
        } else if (arguments.length == 3) {
//设置参数
            storegeditOption(option);
            window.localStorage.setItem(name, value);
        }
    },
    setQueryString: function (data) {
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
        return params; //返回参数值F
    },
    GetQueryStringByEncode: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null)
            return unescape(decodeURI(r[2]));
        return null; //返回参数值F
    },
    isnotnull:function (data) {
        if ("" == data || "undefined" == data || "null" == data || null == data || typeof data == "undefined") {
            return false;
        }
        return true;
    }
}