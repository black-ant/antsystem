package com.msclient.logistics.clientlogistics.view;

import com.msclient.logistics.clientlogistics.common.AbstractView;
import com.msclient.logistics.clientlogistics.entity.InventoryVO;
import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import com.msclient.logistics.clientlogistics.service.InventoryService;
import com.msclient.logistics.clientlogistics.service.StorehouseService;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:14
 * @Version 1.0
 **/
@Named
@Data
public class InventoryView extends AbstractView {

    private List<InventoryVO> inventoryVOS;
    private InventoryVO inventoryVO;

    @Autowired
    InventoryService inventoryService;

    @Override
    protected void init() {
        inventoryVOS= inventoryService.findAll();
    }

    public void addStorehouse() {//添加Company时以一个username来添加管理员不太合理

    }

    public void onRowSelect(SelectEvent event) {
        log.debug("addOrUpdateCompany onRowSelect: " + inventoryVO.getProcode());
        PrimeFaces.current().executeScript("PF('companyDialog').show()");
    }
}
