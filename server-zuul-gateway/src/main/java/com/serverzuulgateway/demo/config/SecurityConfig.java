package com.serverzuulgateway.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/17 22:42
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
