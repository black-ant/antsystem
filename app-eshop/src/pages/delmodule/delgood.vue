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
    <div class="pop-up" v-show="showpop">
      <div class="main">
        <div class="goodmain">
          <img src="../../assets/good1.png" class="goodsimg" width="20%"/>
          <div class="item title">{{selectgood.goodstitle}}</div>
          <div class="item size">{{selectgood.goodsize}}</div>
          <div class="item desc">{{selectgood.goodsdesc}}</div>
        </div>
        <div class="goodtype">
          <div class="itemtype" v-for="(value, key, index) in pageObject" v-if="key!='skuid'">
            <div class="title">{{key}}</div>
            <div class="select">
              <div class="item" v-for="(value1, key1, index1)  in value" v-on:click="selectkey(key,key1,value1)"
                   v-bind:class="{on:index1==addClassfun}">
                {{key1}}
              </div>
            </div>
          </div>
        </div>
        <div class="op-num">
          <div class="title">购买数量</div>
          <div class="right_1">
            <div class="op-num-minus op" v-on:click="buynum=buynum>0?buynum-1:buynum">-</div>
            <div class="op-num-main">{{buynum}}</div>
            <div class="op-num-add op" v-on:click="buynum++">+</div>
          </div>
        </div>
        <div class="op-button">
          <button class="cancel" v-on:click="">取消</button>
          <button class="ensure" v-on:click="ensuregoodfun(selectgood)">确定</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {findGoods} from '@/service/apiGetData'
  import {addGoodsToCart} from '@/service/addData'
  import {findGoodsOne} from '@/service/apiGetData'
  import util from '@/utils/common'

  export default {
    name: 'delgood',
    data() {
      return {
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
        pageObject: {},
        buynum: 1,
        selectSKU: {}
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
        let pageObject = {};
        // 原数据 : {
        // "1":{"颜色":"白色","尺寸":"10*10","skuid":1},
        // "2":{"颜色":"玫瑰色","尺寸":"10*20","skuid":2}
        // }
        // showobj = {
        //   颜色 : { 白色 :[0,1] ，黑色 :[1 ,2] },
        //   尺码 : { 大号 :[0,2] }
        // }
        this.selectgood = data;
        findGoodsOne(data.id, "100001").then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
          Object.keys(re).forEach(function (key) {
            //  对每一条记录进行循环 -》 {"颜色":"白色","尺寸":"10*10","skuid":1}
            let itemObject = re[key];
            let itemSKUID = itemObject.skuid;
            Object.keys(itemObject).forEach(function (itemKey) {
              // 获得每一种种类 -》 "颜色":"白色"  、 "尺寸":"10*10"
              // 种类 -> itemKey : 颜色 、尺寸
              // 值 -> itemValue : 白色 、红色 、大 、小
              let itemValue = itemObject[itemKey];
              // 当前页面渲染对象包含 种类 itemKey
              if (pageObject.hasOwnProperty(itemKey)) {
                // 最终的存储单元 --{白色 ，[ 1 , 2 ]}
                let atomobj = pageObject[itemKey];
                // 当前 种类对象 中 是否包含 该 值 , 例如颜色 种类之中只包含了白色 ，而没有黑色
                if (atomobj.hasOwnProperty(itemValue)) {
                  atomobj[itemValue].push(itemSKUID);
                } else {
                  // 生成 该 值 ， 并且为 其配置 skuid
                  atomobj[itemValue] = [itemSKUID];
                }
              } else {
                // 创建种类对象 -》  尺码 : { 大号 :[0,2] }
                let valueSKUid = [itemSKUID];
                pageObject[itemKey] = {};
                pageObject[itemKey][itemValue] = valueSKUid;
              }
            });
          });
          console.log("=================");
          console.log(pageObject);
          this.pageObject = pageObject;
          this.showpop = true;
        }).catch(err => {
          console.log("press cancel");
        });
      },
      ensuregoodfun: function () {
        console.log("确定选购商品：{}", this.selectgood);
        console.log("确定选购商品 规格：{}", this.selectSKU);
        let itemSKU = this.selectSKU;
        let skuArray = new Array();
        Object.keys(itemSKU).forEach(function (itemKey) {
          //获得第一个sku array
          if (skuArray.length == 0) {
            skuArray = itemSKU[itemKey].skid
          } else {
            let newArray = new Array();
            let next = itemSKU[itemKey];
            for (let x in next) {
              if (skuArray.indexOf(next[x])) {
                newArray.push(next[x]);
              }
            }
          }
        });
        console.log("最终sku:{}", skuArray[0]);
        var cartObject = {
          cartdesc: 'app',
          carttype: 0,
          goodsid: this.selectgood.id,
          skuid: skuArray[0],
          shopId: 100001,
          buyerId: 10001,
          nobodyKey: 'A0001',
          num: this.buynum,
          price: this.selectgood.goodsprice
        }
        addGoodsToCart(cartObject).then(re => {
          console.log("add success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
          this.showpop = false;
          util.showmsg("货品已添加到购物车");
        }).catch(err => {
        });
      },
      selectkey(key, value, skid) {
        console.log("key is :{}", key);
        console.log("value is :{}", value);
        console.log("skid is :{}", skid);
        this.selectSKU[key] = {value: value, skid: skid};
        console.log("selectSKU is :{}", this.selectSKU);
      },

    }
  }
</script>
<style lang="scss" scoped>
  @import 'src/style/common';

  .goodslist button {
    display: inline-block;
    background: #35477D;
    border-radius: 0.2rem;
    color: #fff;
    width: 20vw;
    line-height: 0.48rem;
    margin-top: 0;
  }



</style>
