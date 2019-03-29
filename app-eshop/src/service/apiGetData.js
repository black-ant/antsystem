import axios from '@/service/apicommon';

//查询客户订单
export function findGoods(tp,filter,sid) {
    return axios.post('/findGoods?shopid=' + sid);
}


export function test() {
    console.log("ok");
}


