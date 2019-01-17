package com.serverauthcenter.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/17 22:44
 * @Version 1.0
 **/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers("/test","/oauth/token").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
