<template>
  <div id="_top" class="top_nav">
    <!--<i class="top_left back iconfont icon-back"></i>-->
    <div class="top_menu">{{title}}</div>
    <div class="top_right">
    </div>
  </div>
</template>
<script>

  import {mapActions, mapGetters} from 'vuex'
  export default {
    name: "header",
    data() {
      return {
        header_show: true,
        footer_show: true,
      }
    },
    computed: {
      ...mapGetters(['title']) // 动态计算属性，相当于this.$store.getters.resturantName
    },
    components: {},
  }
</script>
