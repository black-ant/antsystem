<template>
  <!--<app-header v-if="header_show"></app-header>-->
  <div> 这里是中间</div>
  <!--<app-footer v-if="footer_show"></app-footer>-->
</template>

<script>
  // import header from './components/header.vue'
  // import footer from './components/footer.vue'

  export default {
    name: "canpay",
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

<style scoped>

</style>
