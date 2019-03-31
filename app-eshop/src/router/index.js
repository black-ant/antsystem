import Vue from 'vue'
import Router from 'vue-router'
import VueResource from 'vue-resource'

import test from '@/components/mytest'
import test2 from '@/components/mytest2'

import home from '@/pages/common/home'
import payorcer from '@/pages/common/paypage'
import canpay from '@/pages/common/canpayorder'


import delgood from '@/pages/delmodule/delgood'
import delcart from '@/pages/delmodule/delcart'
import delorder from '@/pages/delmodule/delorder'

import header from '@/components/mytest'


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
      path: '/del/delgood',
      name: 'delgood',
      component: delgood
    },
    {
      path: '/del/delcart',
      name: 'delcart',
      component: delcart
    },
    {
      path: '/dl/delorder',
      name: 'delorder',
      component: delorder
    },
    {
      path: '/home',
      name: 'home',
      component: home
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