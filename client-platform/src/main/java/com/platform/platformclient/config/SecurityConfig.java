package com.platform.platformclient.config;

import com.platform.platformclient.filter.BeforeFilter;
import com.platform.platformclient.service.security.JPAUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/14 21:44
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JPAUserDetailsService jpaUserDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHanddle;
    @Autowired
    private AuthenticationFailureHandler loginFailureHandle;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests().
                antMatchers("/index").permitAll().
                antMatchers("/*").permitAll().
                antMatchers("/platform/*").hasRole("USER").
                anyRequest().authenticated().and().
                formLogin().loginPage("/login").defaultSuccessUrl("/01home").
                successHandler(loginSuccessHanddle).failureHandler(loginFailureHandle).permitAll().and().
                logout().logoutUrl("/logout").logoutSuccessUrl("/index").permitAll();

        http.addFilterBefore(new BeforeFilter(), UsernamePasswordAuthenticationFilter.class);
        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.debug("载入加密配置AuthenticationManagerBuilder");
//        auth.userDetailsService(jpaUserDetailsService).passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("gang").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN", "USER").and()
                .withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
//        auth.userDetailsService(jpaUserDetailsService);
    }

    //不定义没有password grant_type
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
