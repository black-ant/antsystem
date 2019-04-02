<template>
  <div class="page-body">
    <div class="page-main module-form">
      <div class="item-module">
        <div class="item item-title">收货人</div>
        <div class="item item-value">
          <input type="text" v-model="addressobj.delName" name="delName" maxlength="60"/>
        </div>
        <div class="item item-icon">
          <div class="iconfont icon-shop"></div>
        </div>
      </div>
      <div class="item-module">
        <div class="item item-title">联系电话</div>
        <div class="item item-value">
          <input type="text" v-model="addressobj.delMobile" name="delMobile" maxlength="60"/>
        </div>
        <div class="item item-icon">
          <div class="iconfont icon-shop"></div>
        </div>
      </div>
      <div class="item-module">
        <div class="item item-title">省市区</div>
        <div class="item item-value">
          <input type="text" v-model="addressobj.delAddress" name="delAddress" maxlength="80" v-on:click="selectAddress"/>
        </div>
        <div class="item item-icon" >
          <div class="iconfont icon-shop"></div>
        </div>
      </div>
      <div class="item-module">
        <div class="item item-title">详细地址</div>
        <div class="item item-value">
          <input type="text" v-model="addressobj.delAddressDetail" name="delAddressDetail" maxlength="100"/>
        </div>
      </div>
      <div class="item-module">
        <div class="item item-title">地址类型</div>
        <div class="item item-value">
          <input type="text" v-model="addressobj.delType" name="delType" maxlength="60"/>
        </div>
      </div>
      <div class="op-button">
        <button class="ensure" v-on:click="ensuregoodfun()">确定</button>
      </div>
      <!--<div class="item-module">-->
      <!--<div class="item-title"></div>-->
      <!--<div class="item-value">-->
      <!--<input type="text" name="delAddress" maxlength="60"/>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="item-module">-->
      <!--<div class="item-title"></div>-->
      <!--<div class="item-value">-->
      <!--<input type="text" name="delAddress" maxlength="60"/>-->
      <!--</div>-->
      <!--</div>-->
    </div>
    <div class="pop-up" v-show="page.showpop">
      <v-distpicker
        :province="newInfo.province"
        :city="newInfo.city"
        :area="newInfo.district"
        :type="newInfo.type"
        @province="getProvince"
        @city="getCity"
        @area="getArea"
      ></v-distpicker>
    </div>
  </div>
</template>

<script>
  import VDistpicker from 'v-distpicker'
  import {addCustomerAddress} from '@/service/addData'

  export default {
    name: 'cusaddress',
    data() {
      return {
        updateIndex: "",
        page: {
          showpop: false
        },
        newInfoEmpty: {
          province: "", //省
          city: "", // 市
          area: "", // 区
          receiveName: "", // 收件人姓名
          addr: "" // 详细地址
        },
        newInfo: {
          province: "", //省
          city: "", // 市
          area: "", // 区
          receiveName: "", // 收件人姓名
          addr: "", // 详细地址
          phone: "",
          type: "mobile"
        },
        receiveInfoArr: [
          // {
          //     id: '',
          //     province: '', //省
          //     city: '', // 市
          //     area: '', // 区
          //     receiveName: '', // 收件人姓名
          //     addr: '', // 详细地址
          // }
        ],
        addressobj: {
          delName: "",
          delMobile: "",
          delAddress: "",
          delAddressDetail: "",
          delType: "",
        }
      };
    },
    components: {VDistpicker},
    methods: {
      selectAddress: function (e){
        console.log("select : selectAddress");
        this.page.showpop =true;
      },
      ensuregoodfun() {
        console.log(JSON.stringify(this.addressobj));
        addCustomerAddress(this.addressobj).then(re => {
          console.log("find success:{}--goolist:{}", JSON.stringify(re), this.goodlist);
        }).catch(err => {
          console.log("press cancel");
        });
      },
      bubble(index) {
        this.currentIndex = index;
      },
      updateProvince(data) {
        // this.receiveInfoArr[this.currentIndex].province = data.value;
      },
      updateCity(data) {
        // this.receiveInfoArr[this.currentIndex].city = data.value;
      },
      updateArea(data) {
        // this.receiveInfoArr[this.currentIndex].district = data.value;
      },
      getProvince(data) {
        console.log("data is :{}", JSON.stringify(data));
        this.addressobj.province = data.value;
      },
      getCity(data) {
        console.log("data is :{}", JSON.stringify(data));
        this.addressobj.city = data.value;
      },
      getArea(data) {
        console.log("data is :{}", JSON.stringify(data));
        this.addressobj.district = data.value;
        this.addressobj.delAddress = this.addressobj.city = this.addressobj.city+ this.addressobj.district;
        this.page.showpop =false;
      },
      getAddress() {

      },
      addAddress() {

      },
      updateAddress(id, index) {

      },
      deleteAddress(id, index) {

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

  /*.pop-up >>> .address-container {*/
  /*max-height: 5rem;*/
  /*overflow-y: scroll;*/
  /*}*/
</style>
