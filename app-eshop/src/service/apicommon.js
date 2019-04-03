import axios from 'axios';
import router from '@/router';

/* 注入vue全局中，这样我们可以在组件内或者JS内通过使用this.$qs来使用qs库*/
import {Toast, MessageBox} from 'mint-ui';

axios.defaults.timeout = 20000;
axios.defaults.baseURL = 'http://localhost:2002';
axios.defaults.headers.common['Authorization'] = "AUTH_TOKEN";
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

// 添加请求拦截器
axios.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  return config;
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error);
});

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
  // if (response.data.result.length === 1) {
    return Promise.resolve(response.data.result);
  // } else {
  //   return Promise.reject(response.data);
  // }
}, function (error) {
  // 对响应错误做点什么
  return Promise.reject(error);
});

export default axios;
