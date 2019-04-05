import axios from '@/service/apicommon';
import util from '@/utils/common';

//查询客户订单
export function findGoods(tp, filter, sid) {
  return axios.post('/findGoods?shopid=' + sid);
}

export function findGoodsOne(gid, shopid, filter) {
  return axios.post('/findOneGoodsByid' + util.setQueryString({gid: gid, shopid: shopid}));
}

export function findCartList(userid, key) {
  return axios.post('/findcart' + util.setQueryString({userid: userid, key: key}));
}

//查询用户地址列表
export function findAddress(uid, filterparam) {
  return axios.post('/getcusaddress' + util.setQueryString({userid: uid, filter: filterparam}));
}

export function findDefaultAddress(uid, filterparam) {
  return axios.post('/finddefaultaddress' + util.setQueryString({userid: uid, filter: filterparam}));
}

export function test() {
  console.log("ok");
}


