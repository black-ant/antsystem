<template>

  <!--<i class="top_left back iconfont icon-back"></i>-->
  <div class="top_nav" v-if="'cm'==showtop">
    <div class="top_menu">{{title}}</div>
    <div class="top_right"></div>
  </div>
  <div class="top_nav" v-else-if="'cr'==showtop">
    <div class="top_nav">
      <div class="top_menu">{{title}}</div>
      <div class="top_right" v-on:click="subright"></div>
    </div>
  </div>
  <div v-else>
    无
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
      ...mapGetters(['title', 'showtop']) // 动态计算属性，相当于this.$store.getters.resturantName
    },
    components: {},
  }
</script>
