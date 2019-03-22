package com.msclient.logistics.clientlogistics.view;

import com.msclient.logistics.clientlogistics.common.AbstractView;
import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import com.msclient.logistics.clientlogistics.service.StorehouseService;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.model.SelectItem;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/21 21:50
 * @Version 1.0
 **/
@Named
@Data
public class StorehouseView extends AbstractView {

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
