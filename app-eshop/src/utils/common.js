export default {
  /**
   *调用某个url参数
   *使用方法:
   *GetQueryString(name)
   **/
  setQueryString: function (data) {
    var params = "";
    if (this.validate(data, 'notnull') && (typeof (data) == "object" && Object.keys(data).length > 0)) {
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
  },
  validate: function (data, type) {
    switch (type) {
      case 'notnull':
        if ("" == data || "undefined" == data || "null" == data || null == data || typeof data == "undefined") {
          return false;
        }
        break;
    }
    return true;
  }
}
