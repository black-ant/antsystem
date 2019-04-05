package com.platform.platformclient.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/15 21:20
 * @Version 1.0
 **/
@Component("loginFailureHandle")
public class LoginFailureHandle extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // AuthenticationException 认证过程中产生的异常
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
//        logger.info("MyAuthenticationSuccessHandler login failure!");
//        logger.info(exception.getMessage());
//        logger.info(exception.getLocalizedMessage());
        exception.printStackTrace();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
    }
}
