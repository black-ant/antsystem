<template>
  <div id="_top" class="top_nav">
    <div class="top_nav">
      <!--<i class="top_left back iconfont icon-back"></i>-->
      <div class="top_menu">{{title}}</div>
      <div class="top_right"></div>
    </div>
  </div>
</template>
<script>

  export default {
    name: "header",
    data() {
      return {
        header_show: true,
        footer_show: true,
      }
    },
    components: {},
  }
</script>
