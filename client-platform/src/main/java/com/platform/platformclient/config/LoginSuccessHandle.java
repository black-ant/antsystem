package com.platform.platformclient.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/15 21:18
 * @Version 1.0
 **/
@Component("loginSuccessHanddle")
public class LoginSuccessHandle extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        logger.info("MyAuthenticationSuccessHandler login success!");
        response.setContentType("application/json;charset=UTF-8");         // 把authentication对象转成 json 格式 字符串 通过 response 以application/json;charset=UTF-8 格式写到响应里面去
        response.getWriter().write(objectMapper.writeValueAsString(authentication));
        logger.info((String)request.getSession().getAttribute("username"));
        super.onAuthenticationSuccess(request, response, authentication);

    }
}
