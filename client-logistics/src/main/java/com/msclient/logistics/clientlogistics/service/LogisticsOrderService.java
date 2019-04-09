package com.msclient.logistics.clientlogistics.service;

import com.alibaba.fastjson.JSONObject;
import com.msclient.logistics.clientlogistics.entity.CarInfoVO;
import com.msclient.logistics.clientlogistics.entity.LogisticsOrderVO;
import com.msclient.logistics.clientlogistics.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 19:56
 * @Version 1.0
 **/
@Service
public class LogisticsOrderService extends BaseService {
    Logger logger = LoggerFactory.getLogger(getClass());

    public List<LogisticsOrderVO> findAll() {
        logger.info("查询订单：");
        String wrapper = serverOrderMapper.findallLogisticsOrder("ALL");
        List<LogisticsOrderVO> list = JSONUtils.wrapperToList(wrapper, LogisticsOrderVO.class);
        logger.info("list is :{}", JSONObject.toJSONString(list));
        return list;
    }

    public List<LogisticsOrderVO> findAllByCache() {
        logger.info("查询订单 cache 缓存：>>>>>>");
        List<String> wrapper = cacheMapper.getOrderList("ALL");
        logger.info("查询订单 cache 缓存结果：{}", JSONObject.toJSONString(wrapper));
        List<LogisticsOrderVO> list = new LinkedList<>();
        for (String sjosn : wrapper) {
            list.add(JSONObject.parseObject(sjosn).toJavaObject(LogisticsOrderVO.class));
        }
        logger.info("list is :{}", JSONObject.toJSONString(list));
        return list;
    }
}
