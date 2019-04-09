package com.msclient.logistics.clientlogistics.view;

import com.msclient.logistics.clientlogistics.common.AbstractView;
import com.msclient.logistics.clientlogistics.entity.CarInfoVO;
import com.msclient.logistics.clientlogistics.entity.CarVO;
import com.msclient.logistics.clientlogistics.service.CarInfoService;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 15:54
 * @Version 1.0
 **/
@Named
@Data
public class DelOrderView extends AbstractView {

    Logger logger = LoggerFactory.getLogger(getClass());

    private List<CarInfoVO> carInfoVOS;
    private List<CarVO> carVOS;
    private CarVO carVO;
    private CarInfoVO carInfoVO;

    @Autowired
    CarInfoService carInfoService;

    @Override
    protected void init() {
        carVOS = new LinkedList<>();
        carVOS.add(new CarVO(1L,114.294085,30.56781));
        carVOS.add(new CarVO(2L,114.304085,30.56781));
        carVOS.add(new CarVO(3L,114.334085,30.56781));
    }

    public void findOneInfo() {
        logger.info("find by car id :{}",carVO.getCarId());
        carInfoVOS= carInfoService.findCarInfoByCarid(carVO.getCarId());
        PrimeFaces.current().executeScript("PF('infoDiolog').show()");
        PrimeFaces.current().executeScript(" baidumap.init('fm:mapcontainer')");
    }

    public void onRowSelect(SelectEvent event) {
        log.debug("选择司机先生经销商 onRowSelect: " + carVO.getCarId());
        findOneInfo();
    }
}
