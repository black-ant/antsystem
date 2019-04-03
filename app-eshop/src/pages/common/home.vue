<template>
  <div class="content">
    <div class="title"> {{title}}</div>
    <div class="item" @click="">点击</div>
  </div>
</template>

<script>

  import {mapActions, mapGetters} from 'vuex'

  export default {
    name: "home",
    data() {
      return {}
    },
    mounted: function () {
      console.log("执行activated");
      changetitle('首页222');
      changetop("cm");
    },
    computed: {
      ...mapGetters(['title','showtop'])
    },
    methods: {
      ...mapActions(
        ['changetitle','changetop']
      ),
    }
  }
</script>

<style scoped>

</style>
