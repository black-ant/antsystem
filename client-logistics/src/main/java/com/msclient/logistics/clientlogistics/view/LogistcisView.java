package com.msclient.logistics.clientlogistics.view;

import com.alibaba.fastjson.JSONObject;
import com.msclient.logistics.clientlogistics.common.AbstractView;
import com.msclient.logistics.clientlogistics.entity.Info;
import com.msclient.logistics.clientlogistics.entity.LogisticsOrderVO;
import com.msclient.logistics.clientlogistics.service.InfoService;
import com.msclient.logistics.clientlogistics.service.LogisticsOrderService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 20:08
 * @Version 1.0
 **/
@Named
@Data
public class LogistcisView extends AbstractView {

    Logger logger = LoggerFactory.getLogger(getClass());
    private static final long serialVersionUID = -814938721259900592L;

    @Autowired
    private LogisticsOrderService logisService;
    private LogisticsOrderVO logisVO;
    private List<LogisticsOrderVO> list;

    @Override
    protected void init() {
        findAllDelOrder();
    }

    public void findAllDelOrder() {
        list = logisService.findAllByCache();
        if (list.isEmpty()) {
            list = logisService.findAll();
        }
        logger.info("list is :{}", JSONObject.toJSONString(list));
    }

    /**
     * 查询所有信息
     */
    public List<LogisticsOrderVO> infoList() {
        list = logisService.findAll();
        return list;
    }

    /**
     * 查询指定 id 信息
     */
    public void selectOne(Integer id) {

    }

    /**
     * 更新信息
     */
    public void update(Info info) {

    }


}
