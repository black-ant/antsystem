<template>
  <div id="banner_down_id" class="bottom_nav">
    <a href="/" class="item">
      <div class="iconfont icon-home"></div>
      首页
    </a>
    <a href="/del/report" class="item del_class" data-count="1">
      <div class="iconfont icon-report"></div>
      报表
    </a>
    <a href="/del/delgood" class="item sale_class">
      <div class="iconfont icon-shop"></div>
      商城
    </a>
    <a href="/del/delcart" class="item cart_count_class" data-count="0">
      <div class="iconfont icon-shop-cart"></div>
      购物车
    </a> <a href="/menu/myself" class="item my_class">
    <div class="iconfont icon-myself"></div>
    我的
  </a>
  </div>
</template>
<script>

  export default {
    name: "footer",
    data() {
      return {
        header_show: true,
        footer_show: true,
      }
    },
    components: {

    },
  }
</script>
