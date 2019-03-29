<template>
<div class="hello" id="_test">
<h1>{{msg}}</h1>
 	<div><router-link to="/test2">点我调到第二页</router-link></div>
 	<div><router-link to="/test1">点我调到第一页</router-link></div>
 	<div><router-link to="/good">点我调到第一页</router-link></div>
</div>
</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      msg: '欢迎来到菜鸟教程1！'
    }
  }
}
</script>
