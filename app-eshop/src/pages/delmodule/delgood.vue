<template>
  <div class="goodslist" id="_good">
    <div class="title">{{msg}}</div>
    <button type="primary" size="large" :disabled="disCommitBtn" v-on:click="findgoods">查询商品</button>
    <div>{{type}}</div>
    <div class="cart_container" v-for="item in goodlist">
      <div class="cart-list-item" :data-uid="item.goodscode">
        <div class="item img">
          <img src="./assets/good1.png" class="" width="100%"/>
        </div>
        <div class="item title">{{item.goodstitle}}</div>
        <div class="item size">{{item.goodsize}}</div>
        <div class="item desc">{{item.goodsdesc}}</div>
      </div>
    </div>
  </div>
</template>

<script>
  import {findGoods} from '@/service/apiGetData';

  export default {
    name: 'delgood',
    data() {
      return {
        imgUrl : '../assets/good1.png',
        title:'商城',
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

  .goodslist .title{
    line-height: 0.72rem;
    display: inline-block;
    width: 40vw;
    font-size: 0.36rem;
  }
  .goodslist button{
    display: inline-block;
    background: #35477D;
    border-radius: 0.2rem;
    color: #fff;
    width: 20vw;
    line-height: 0.48rem;
    margin-top: 0;
  }
  .cart-list-item {
    box-shadow: 0 0.02rem 0.38rem 0 #DDE8F;
    width: 92%;
    background-color: #FFFFFF;
    margin: .3rem auto;
    border-radius: 0.16rem;
  }
</style>
