<template>
  <div class="goodslist" id="_good">
    <h1>{{msg}}</h1>
    <div class="cart_container" v-for="item in items">
      <div class="cart-list-item">
        <div class="item"></div>
        <div class="item"></div>
        <div class="item"></div>
      </div>
    </div>
    <button type="primary" size="large" :disabled="disCommitBtn" style="margin-top: 1em;" v-on:click="findgoods">查询商品
    </button>
  </div>
</template>

<script>
  import {findGoods} from '@/service/apiGetData';

  export default {
    name: 'goodslist',
    data() {
      return {
        msg: '欢迎来到菜鸟教程1！'
      }
    },
    methods: {
      findgoods(e) {
        findGoods('', '', '100001').then(data => {
          console.log("find success:{}");
        }).catch(err => {
          console.log("press cancel");
        });
      },

    }
  }
</script>
<style lang="scss" scoped>
  @import 'src/style/common';
</style>
