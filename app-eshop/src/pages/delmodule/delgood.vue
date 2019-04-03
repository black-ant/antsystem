<template>
  <div class="goodslist" id="_good">
    <div class="title">{{msg}}</div>
    <button type="primary" size="large" :disabled="disCommitBtn" v-on:click="findgoods">查询商品</button>
    <div class="cart_container" v-for="item in goodlist">
      <div class="cart-list-item" :data-uid="item.goodscode" v-on:click="selectgoodfun(item)">
        <div class="item img">
          <img src="../../assets/good1.png" class="goodsimg" width="20%"/>
        </div>
        <div class="item title">{{item.goodstitle}}</div>
        <div class="item size">{{item.goodsize}}</div>
        <div class="item desc">{{item.goodsdesc}}</div>
      </div>
    </div>
    <div class="pop-up" v-show="showpop" >
      <div class="goodmain">
        <img src="../../assets/good1.png" class="goodsimg" width="20%"/>
        <div class="item title">{{selectgood.goodstitle}}</div>
        <div class="item size">{{selectgood.goodsize}}</div>
        <div class="item desc">{{selectgood.goodsdesc}}</div>
      </div>
      <div class="goodtype">
        <div class="itemtype" v-for="(value, key, index) in showsku">
          <div class="title">{{key}}</div>
          <div class="select">
            <div class="item" v-for="(value1, key1, index1)  in value">{{value.key1}}</div>
          </div>
        </div>
      </div>
      <div class="op-button">
        <button class="cancel" v-on:click="">取消</button>
        <button class="ensure" v-on:click="ensuregoodfun(selectgood)">确定</button>
      </div>
    </div>
  </div>
</template>

<script>
  import {findGoods} from '@/service/apiGetData'
  import {findGoodsOne} from '@/service/apiGetData'
  import imggood1 from '../../assets/good1.png'

  export default {
    name: 'delgood',
    data() {
      return {
        imgUrl: imggood1,
        title: '商城',
        msg: '欢迎选购货品！',
        type: 'true',
        goodlist: new Array(),
        selectgood: {
          goodstitle: '商品标题',
          goodsize: '商品尺码',
          goodsdesc: '商品描述',
          sizetype: [{'id': '1', 'desc': '大'}, {'id': '2', 'desc': '小'}]
        },
        showpop: false,
        showsku:{},
      };
    },
    methods: {
      findgoods(e) {
        findGoods('', '', '100001').then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
          this.goodlist = re;
          this.type = "false";
          console.log("data is:{}", JSON.stringify(this.goodlist));
        }).catch(err => {
          console.log("press cancel");
        });
        // test();
      },
      selectgoodfun: function (data) {
        var obj = console.log(JSON.stringify(data));
        let showobj = {};
        findGoodsOne(data.id,"100001").then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
          Object.keys(re).forEach(function(key){
            let objitem = re[key];
            Object.keys(objitem).forEach(function(id){
              console.log(id,objitem[id]);
              let obj = {id:objitem.skuid,value:objitem[id]};
              if(showobj.hasOwnProperty(id)){
                showobj[id].push(obj);
              }else{
                let array = new Array();
                array.push(obj);
                showobj[id]=array;
              }
            });
          });
          console.log(showobj);
          this.showsku = showobj;
          this.showpop = true;
        }).catch(err => {
          console.log("press cancel");
        });
      },
      ensuregoodfun: function (data) {

      }
    }
  }
</script>
<style lang="scss" scoped>
  @import 'src/style/common';

  .goodslist .title {
    line-height: 0.72rem;
    display: inline-block;
    width: 64vw;
    text-align: left;
    font-size: 0.36rem;
  }

  .goodslist button {
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
    display: inline-block;
    text-align: left;
    margin: .3rem auto;
    border-radius: 0.16rem;
  }

  .cart-list-item img {
    display: block;
    float: left;
  }

</style>
