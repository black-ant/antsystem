<template>
  <div class="content">
    <div class="title"> {{title}}</div>
    <div class="item" @click=" ;">点击</div>
  </div>
</template>

<script>

  import {mapActions, mapGetters} from 'vuex'

  export default {
    name: "home",
    data() {
      return {}
    },
    activated: function () {
      console.log("执行activated");
      changetitle('首页222')
    },
    computed: {
      ...mapGetters(['title']) // 动态计算属性，相当于this.$store.getters.resturantName
    },
    methods: {
      ...mapActions(
        ['changetitle']
      ),
    }
  }
</script>

<style scoped>

</style>
