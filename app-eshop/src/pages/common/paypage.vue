<template>
  <!--<app-header v-if="header_show"></app-header>-->
  <div> 这里是中间</div>
  <!--<app-footer v-if="footer_show"></app-footer>-->
</template>

<script>
  // import header from './components/header.vue'
  // import footer from './components/footer.vue'

  export default {
    name: "111",
    data() {
      return {
        header_show: true,
        footer_show: true,
      }
    },
    components: {
      // 'app-header': header,
      // 'app-footer': footer,
    },
  }
</script>

<style scoped>

</style>
