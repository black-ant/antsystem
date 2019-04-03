<template>

  <div id="app">
    <div class="top">
      <app-header v-if="header_show"></app-header>
    </div>
    <router-view/>
    <div class="bottom">
      <app-footer v-if="footer_show"></app-footer>
    </div>
  </div>

</template>
<script>
  import home from './pages/common/home.vue'
  import header from '@/components/header'
  import footer from '@/components/footer'

  export default {
    name: 'App',
    data() {
      return {
        header_show: true,
        footer_show: true,
      }
    }, components: {
      'home': home,
      'app-header': header,
      'app-footer': footer,
    },
  }

</script>

<style>
  @import "./style/common.css";
  @import "./style/iconfont.css";

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }

  .icon {
    width: 1em;
    height: 1em;
    vertical-align: -0.15em;
    fill: currentColor;
    overflow: hidden;
  }
</style>
