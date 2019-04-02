import axios from '@/service/apicommon';
import qs from 'qs'

//查询客户订单
export function addCustomerAddress(obj) {
  return axios.post('/addcusaddress',qs.stringify(obj));
}

export function test() {
  console.log("ok");
}


