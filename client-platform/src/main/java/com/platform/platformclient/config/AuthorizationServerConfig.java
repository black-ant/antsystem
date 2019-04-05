package com.platform.platformclient.config;

import com.platform.platformclient.service.security.JPAUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/14 21:45
 * @Version 1.0
 **/
//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Autowired
    private JPAUserDetailsService jpaUserDetailsService;

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(jpaUserDetailsService)//若无，refresh_token会有UserDetailsService is required错误
                .tokenStore(tokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 使用内存存储客户端信息
                .withClient("resource1")       // client_id
                .secret("secret")                   // client_secret
                .authorizedGrantTypes("authorization_code","password")     // 该client允许的授权类型
                .accessTokenValiditySeconds(3600)               // Token 的有效期
                .scopes("read")                    // 允许的授权范围
                .autoApprove(true);                  //登录后绕过批准询问(/oauth/confirm_access)

//        clients.inMemory()
//                .withClient("android")
//                .scopes("xx")
//                .secret(new BCryptPasswordEncoder().encode("123456"))
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                .and()
//                .withClient("webapp")
//                .scopes("xx")
//                .authorizedGrantTypes("implicit")
//                .and()
//                .withClient("browser")
//                .authorizedGrantTypes("refresh_token", "password")
//                .scopes("ui");
    }
}
