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
  },
  showmsg: function (message) {
    $("#show-msg").html(message).show().animate({width: '80vw'}, 400).fadeOut(2400);
    setTimeout(function () {
      $("#show-msg").css("width", "0px");
    }, 2400)
  },
  showerror: function (message) {
    $("#show-msg").css("background", "#f47272").html(message).show().animate({width: '80vw'}, 400).fadeOut(3300);
    setTimeout(function () {
      $("#show-msg").css({"width": "0px", "background": "#558bc3"});
    }, 3300)
  },
  showinfo: function (message) {
    $("#show-msg").css("background", "#fb8600").html(message).show().animate({width: '80vw'}, 400).fadeOut(3300);
    setTimeout(function () {
      $("#show-msg").css({"width": "0px", "background": "#558bc3"});
    }, 3300)
  }
}
