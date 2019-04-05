<template>
  <div class="goodslist" id="_good">
    <div class="cart_container" v-for="item in goodlist">
      <div class="cart-list-item" :data-uid="item.goodscode" v-on:click="selectgoodfun(item)">
        <div class="item img">
          <img src="../../assets/good1.png" class="goodsimg" width="20%"/>
        </div>
        <div class="item title">{{item.goodstitle}}</div>
        <div class="item size">{{item.goodsize}}</div>
        <div class="item desc">{{item.goodsdesc}}</div>
        <div class="op-num">
          <div class="left-op">
            ¥ {{item.price}}
          </div>
          <div class="right_1">
            <div class="op-num-minus op" v-on:click="buynum=buynum>0?buynum-1:buynum">-</div>
            <div class="op-num-main">{{buynum}}</div>
            <div class="op-num-add op" v-on:click="buynum++">+</div>
          </div>
        </div>
      </div>
    </div>
    <div class="module-form">
      <div class="op-msg">
        ¥ {{goodsprice}}
      </div>
      <div class="op-button">
        <button class="ensure" v-on:click="ensuregoodfun()">确定</button>
      </div>
    </div>
    <div class="pop-up" v-show="showpop">
      <div class="main">

      </div>
    </div>
  </div>
</template>

<script>
  import {findCartList} from '@/service/apiGetData'

  export default {
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
        selectSKU: {},
        goodsprice : 0
      };
    },
    mounted: function () {
      this.findgoods();
    },
    methods:
      {
        findgoods() {
          findCartList('10001', "").then(re => {
            console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
            this.goodlist = re;
            this.goodsprice = 999
          }).catch(err => {
            console.log("press cancel");
          });
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
          this.$router.push('/del/delorder');
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

  .op-num {
    display: inline-block;
    width: 100%;
  }

  .op-num .left-op {
    width: 40%;
    float: left;
    line-height: 0.5rem;
    padding: 0.2rem 0.3rem;
    color: #d02600;
    font-size: 0.4rem;
  }

  .op-num .right_1 {
    width: 50%;
    float: right;
    padding: 0.2rem;
  }
  .module-form{
    position: fixed;
    bottom: 1rem;
    width: 100%;
    background: #fff;
  }
  .module-form .op-msg{
    width: 40%;
    float: left;
    line-height: 0.5rem;
    padding: 0.2rem 0.3rem;
    color: #d02600;
    font-size: 0.4rem;
  }

</style>
