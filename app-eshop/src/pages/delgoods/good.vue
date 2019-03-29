<template>
<div class="goodslist" id="_good">
<h1>{{msg}}</h1>
 <button type="primary" size="large" :disabled="disCommitBtn" style="margin-top: 1em;"  v-on:click="findgoods">查询商品</button>
</div>
</template>

<script>
import {findGoods} from '@/service/apiGetData';

export default {
  name: 'goodslist',
  data () {
    return {
      msg: '欢迎来到菜鸟教程1！' 
    };
  },
  methods:{
    findgoods(e) {
        findGoods('', '', '100001').then(data => {
            console.log("find success:{}");
        }).catch(err => {
            console.log("press cancel");
        });
        // test();
    },

  }
}
</script>
<style lang="scss" scoped>
    @import 'src/style/common';
</style>
