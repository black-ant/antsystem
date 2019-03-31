<template>
  <div class="goodslist" id="_good">
    <h1>{{msg}}</h1>
    <button type="primary" size="large" :disabled="disCommitBtn" style="margin-top: 1em;" v-on:click="findgoods">查询商品</button>
    <div>{{type}}</div>
    <div class="cart_container" v-for="item in goodlist">
      <div class="cart-list-item">
        <div class="item">{{item.goodscode}}</div>
        <div class="item">{{item.goodstitle}}</div>
        <div class="item">{{item.goodsdesc}}</div>
      </div>
    </div>
  </div>
</template>

<script>
  import {findGoods} from '@/service/apiGetData';

  export default {
    name: 'goodslist',
    data() {
      return {
        msg: '欢迎选购货品！',
        type:'true',
        goodlist: new Array()
      };
    },
    methods: {
      findgoods(e) {
        findGoods('', '', '100001').then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
          this.goodlist = re;
          this.type="false";
          console.log("data is:{}", JSON.stringify(this.goodlist));
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
