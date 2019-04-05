package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.common.utils.DateUtil;
import com.dataserver.eshop.serverdataeshop.entity.TradeOrder;
import com.dataserver.eshop.serverdataeshop.entity.VO.TradeVO;
import com.dataserver.eshop.serverdataeshop.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/4 20:18
 * @Version 1.0
 **/
@Service
public class TradeService {

    @Autowired
    TradeRepository tradeRepository;

    @Transactional
    public void saveTradeOrder(TradeVO tradeVO){
        TradeOrder tradeOrder = new TradeOrder(tradeVO,"10000001"+ DateUtil.getStringYYMMDD());
        tradeRepository.save(tradeOrder);
    }
}
