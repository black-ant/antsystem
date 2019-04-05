这是一个商城、物流 微服务项目 , 基于 SpringCloud 。
该项目为学习 , 优化技能 而生 . 

## 项目组成
  -  app-shop : 基于 Cordova + Vue 实现的App 购物商城
  -  client - eshop : 商城后台 
  -  client - logistics : 物流后台
  -  client - platform : 平台后台
  -  server - authcenter : 授权管理器
  -  server - config : 统一配置中心
  -  server - data - shop : 商城服务供应商
  -  server - data - order : 订单系统服务供应商 
  -  server - data - shop : 人员管理服务供应商
  -  server - registry : 注册中心
  -  server - zuul - gateway : 路由中心
  
  
  ## 技术点图谱
  -  核心 ： springCloud 系列 , Eureka 服务发现 ,OpenFeign 服务调用
  -  cordova , vue , HTML5 可参考  app-shop
  -  client - platform : primeface , JSF , JPA
  -  其余 ： JPA + thymeleaf + SpringMVC
