package com.platform.platformclient.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/15 21:23
 * @Version 1.0
 **/
public class BeforeFilter extends GenericFilterBean {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("This is a filter before UsernamePasswordAuthenticationFilter.");
        logger.info("getRemoteHost:{}",servletRequest.getRemoteHost());
        logger.info("getContentType:{}",servletRequest.getContentType());
        logger.info("getLocalName:{}",servletRequest.getLocalName());
        logger.info("getLocalAddr:{}",servletRequest.getLocalAddr());
        logger.info("getServerName:{}",servletRequest.getServerName());
        logger.info("getServerName:{}",servletRequest.getRemoteAddr());
        logger.info("getServerName:{}",servletRequest.getServletContext());
//        CommonUtils.reflect(servletRequest);
        // 继续调用 Filter 链
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
