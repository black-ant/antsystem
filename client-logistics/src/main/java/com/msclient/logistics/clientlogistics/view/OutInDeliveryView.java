package com.msclient.logistics.clientlogistics.view;

import com.msclient.logistics.clientlogistics.common.AbstractView;
import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import com.msclient.logistics.clientlogistics.service.StorehouseService;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 10169
 * @Description 出入库记录
 * @Date 2019/3/27 13:14
 * @Version 1.0
 **/
public class OutInDeliveryView extends AbstractView {

    private List<StorehouseVO> storelist;
    private StorehouseVO selectVO;

    @Autowired
    StorehouseService storehouseService;
    @Override
    protected void init() {
        storelist= storehouseService.findAll();
    }

    public void addStorehouse() {//添加Company时以一个username来添加管理员不太合理

    }

    public void onRowSelect(SelectEvent event) {
        log.debug("addOrUpdateCompany onRowSelect: " + selectVO.getId());
        PrimeFaces.current().executeScript("PF('companyDialog').show()");
    }
}
