package com.dataserver.eshop.serverdataeshop.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 20:58
 * @Version 1.0
 **/

@Aspect
public class LoggerAspect {

    Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution(* com.dataserver.eshop.serverdataeshop.service.GoodsService.saveGoods(..))")
    public void savePoint(){}

    @Before("savePoint()")
    public void beforesave(){
        logger.debug("货品已保存");
    }

//    @DeclareParents(value=" com.dataserver.eshop.serverdataeshop.common.AspectInto",defaultImpl = CommonService.class)
//    public static AspectInto aspectInto;

}
