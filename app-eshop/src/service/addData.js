import axios from '@/service/apicommon';
import qs from 'qs'
// import util from '@/utils/common';
// axios 传递数组后台接收不到的解决思路
//  1 后台用@RequestBody , 前台仅需设定为  "Content-Type": "application/json;charset=utf-8"
//  2 全部转换为String 后台@RequestBody 接收


//查询客户订单
export function addCustomerAddress(obj) {
  return axios.post('/addcusaddress',qs.stringify(obj));
}

// 加入购物车
export function addGoodsToCart(obj) {
  return axios.post('/addcart',qs.stringify(obj));
}

// 生成订单

export function doTrade(obj) {
  return axios.post('/trade',obj,{
    headers: {
      "Content-Type": "application/json;charset=utf-8"  //头部信息
    }
  });
  // return axios.post('/trade',JSON.stringify(obj));
}
export function test() {
  console.log("ok");
}


