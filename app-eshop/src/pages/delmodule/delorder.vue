<template>
  <div class="page-body">
    <div class="page-main">
      <div class="page-select" v-if="isselect">
        <div class="head-img">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-position"></use>
          </svg>
        </div>
        <div class="main-msg">
          <div class="title">{{nowselect.delName}} <span>{{nowselect.delMobile}}</span></div>
          <div class="other">{{nowselect.delAddress}}-{{nowselect.delAddress}}</div>
        </div>
        <div class="right-icon">
          <div class="iconfont icon-right"></div>
        </div>
      </div>
      <div class="border-bk"></div>
      <div class="goodslist" v-for="item in goodlist">
        <div class="cart-list-item" :data-uid="item.goodscode" v-on:click="selectgoodfun(item)">
          <div class="item img">
            <img src="../../assets/good1.png" class="goodsimg" width="20%"/>
          </div>
          <div class="item title">{{item.goodstitle}}</div>
          <div class="item size">{{item.goodsize}}</div>
          <div class="item desc">{{item.goodsdesc}}</div>
          <div data-v-7cf5367f="" class="op-num">
            <div data-v-7cf5367f="" class="left-op">
              ¥ 999
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="module-form">
      <div class="op-msg">
        ¥ {{goodsprice}}
      </div>
      <div class="op-button">
        <button class="ensure" v-on:click="ensuregoodfun()">结算</button>
      </div>
    </div>
  </div>
</template>

<script>
  import {findDefaultAddress} from '@/service/apiGetData'
  import {findCartList} from '@/service/apiGetData'
  import {doTrade} from '@/service/addData'
  import imggood1 from '../../assets/good1.png'

  export default {
    name: "delorder",
    data() {
      return {
        updateIndex: "",
        page: {
          showpop: false
        },
        addressarray: new Array(),
        goodlist: new Array(),
        nowselect: {},
        isselect: true,
        goodsnum: 9,
        goodsprice: 999,
        userid: 10001
      };
    },
    created: function () {
      this.addresslist();
      this.findgoods();
    },
    methods: {
      addresslist() {
        findDefaultAddress('10001', 'no').then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.nowselect);
          this.nowselect = re;
        }).catch(err => {
          console.log("press cancel");
        });
      },
      findgoods() {
        findCartList('10001', "").then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
          this.goodlist = re;
          this.goodsprice = 999
        }).catch(err => {
          console.log("press cancel");
        });
      },
      ensuregoodfun: function (item) {
        let tradeItemArray = new Array();
        for (let x in this.goodlist) {
          let itemGoods = this.goodlist[x];
          let itemObject = {
            shopid: itemGoods.shopId,
            itemId: itemGoods.goodsid,
            title: itemGoods.goodstitle,
            itemType: 1,
            skuId: itemGoods.skuid,
            skuPropertiesName: "0000",
            price: itemGoods.price,
            num: itemGoods.num,
            buyerMessages: "",
            snapshotId: 0,
          };
          tradeItemArray.push(itemObject);
        }
        let tradeObject = {
          itemVOS: tradeItemArray,
          type: 0,
          num: this.goodsnum,
          ordernum: tradeItemArray.length,
          goodscode: "",
          price: this.goodsprice,
          buyuserid: this.userid,
          buyerMessage: "备注",
          price: this.goodsprice,
          price: this.goodsprice,
          delAddress: this.delAddress,
          delAddressDetail: this.delAddressDetail,
          delName: this.delName,
          delMobile: this.delMobile,
          delPlace: "0",
          delZip: 0,
          delType: 0,

        }
        doTrade(tradeObject).then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
        }).catch(err => {
          console.log("press cancel");
        });
      }
    }
  }
</script>

<style scoped>
  .page-main {
    font-size: 0.3rem;
  }

  .page-main .page-select .main-msg span {
    font-size: 0.3rem;
    float: right;
    margin-right: 0.3rem;
    color: #000;
  }

  .op-num {
    text-align: right;
  }

  .page-main .page-select {
    display: inline-block;
    margin: 0.1rem 0;
    border-bottom: 0.2rem solid #F0F0F0;
    width: 100%;
  }

  .module-form {
    position: fixed;
    bottom: 1rem;
    width: 100%;
    background: #fff;
  }

  .module-form .op-msg {
    width: 40%;
    float: left;
    line-height: 0.5rem;
    padding: 0.2rem 0.3rem;
    color: #d02600;
    font-size: 0.4rem;
  }
</style>
