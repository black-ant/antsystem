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
    </div>
  </div>
</template>

<script>
  import {findDefaultAddress} from '@/service/apiGetData'

  export default {
    name: "delorder",
    data() {
      return {
        updateIndex: "",
        page: {
          showpop: false
        },
        addressarray: new Array(),
        nowselect: {},
        isselect: true,
      };
    },
    created: function () {
      this.addresslist();
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
      selectone: function (item) {

      }
    }
  }
</script>

<style scoped>
.page-main{
  font-size: 0.3rem;
}
.page-main .page-select .main-msg span {
  font-size: 0.3rem;
  float: right;
  margin-right: 0.3rem;
  color: #000;
}
.page-main .page-select {
  display: inline-block;
  margin: 0.1rem 0;
  border-bottom: 0.2rem solid #F0F0F0;
  width: 100%;
}
</style>
