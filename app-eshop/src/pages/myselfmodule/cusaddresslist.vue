<template>
  <div class="page-body">
    <div class="page-main module-list">
      <div class="page-select" v-if="isselect">
        <div class="head-img">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-position"></use>
          </svg>
        </div>
        <div class="main-msg">
          <div class="title">{{nowselect.delName}} <span>{{nowselect.delMobile}}</span></div>
          <div class="other">{{nowselect.delAddress}}+{{nowselect.delAddress}}</div>
        </div>
        <div class="right-icon">
          <div class="iconfont icon-shop"></div>
        </div>
      </div>
      <div class="list-item" v-for="item in addressarray" v-show="addressarray.length>0" v-on:click="selectone(item)">
        <div class="head-img">{{item.delName.slice(0,1)}}</div>
        <div class="main-msg">
          <div class="title">{{item.delName}} <span>{{item.delMobile}}</span></div>
          <div class="other">{{item.delAddress}}+{{item.delAddress}}</div>
        </div>
        <div class="right-icon">
          编辑
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {findAddress} from '@/service/apiGetData'

  export default {
    name: 'cusaddresslist',
    data() {
      return {
        updateIndex: "",
        page: {
          showpop: false
        },
        addressarray: new Array(),
        nowselect: {},
        isselect: false,
      };
    },
    created: function () {
      this.addresslist();
    },
    components: {},
    methods: {
      addresslist() {
        findAddress('10001', 'no').then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.addressarray);
          this.addressarray = re;
        }).catch(err => {
          console.log("press cancel");
        });
      },
      selectone: function (item) {
        this.isselect = true;
        this.nowselect = item;
      }
    }
  }
</script>

<style scoped>
  .pop-up {
    height: 400px;
    overflow-y: auto;
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
  }

  .pop-up >>> .distpicker-address-wrapper {
    color: #999;
  }

  .pop-up >>> .address-header {
    position: fixed;
    bottom: 400px;
    width: 100%;
    background: #30446d;
    color: #fff;

  }

  .pop-up >>> .address-header ul li {
    flex-grow: 1;
    text-align: center;
  }

  .pop-up >>> .address-header .active {
    color: #fff;
    border-bottom: #f1bbbb solid 4px;
  }

  .pop-up >>> .address-container .active {
    color: #000;
  }
  .icon {
    width: 2em;
    height: 2em;
    vertical-align: -0.7em;
    fill: currentColor;
    overflow: hidden;
  }
</style>
