import Vue from 'vue'
import Router from 'vue-router'
import VueResource from 'vue-resource'
import test from '@/components/mytest'
import test2 from '@/components/mytest2'
import good from '@/pages/delgoods/good'

Vue.use(Router);
Vue.use(VueResource);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'test',
      component: test
    },
    {
      path: '/good',
      name: 'good',
      component: good
    },
    {
      path: '/test1',
      component: test
    },
    {
      path: '/test2',
      component: test2
    }
  ]
})
