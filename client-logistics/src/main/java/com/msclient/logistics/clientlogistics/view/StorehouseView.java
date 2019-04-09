package com.msclient.logistics.clientlogistics.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.msclient.logistics.clientlogistics.common.AbstractView;
import com.msclient.logistics.clientlogistics.entity.StoreUserVO;
import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import com.msclient.logistics.clientlogistics.service.StorehouseService;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    private List<SelectItem> storelist;
    private List<StorehouseVO> storeObjectlist;
    private StorehouseVO selectVO;
    private StorehouseVO newStorehouse;

    private List<StoreUserVO> userVOS;
    private StoreUserVO selectUser;
    private StoreUserVO changeUser;

    //仓库员工管理查询仓库
    private StorehouseVO findStore;
    private String selectStroehouse;

    @Autowired
    StorehouseService storehouseService;


    @Override
    protected void init() {
        logger.info("init : 查询所有仓库");
        getStroehouse();
        initNewHouse();
    }

    public void addStorehouse() {
        log.info("保存新对象 :{}", JSONObject.toJSONString(newStorehouse));
        newStorehouse = storehouseService.saveOne(newStorehouse);
        storeObjectlist.add(newStorehouse);
        storelist.add(new SelectItem(newStorehouse.getId(), newStorehouse.getAddressdetail()));
        log.info("list :storeObjectlist -> {}, storelist - >{}", JSONObject.toJSONString(storeObjectlist), JSONObject.toJSONString(storelist));
        PrimeFaces.current().executeScript("PF('diaWarehouse').show()");
    }

    public void initNewHouse() {
        log.info("创建新对象");
        newStorehouse = new StorehouseVO();
    }

    public void getStroehouse() {
        storelist = new ArrayList<>();
        storeObjectlist = storehouseService.findAll();
        for (StorehouseVO storehouseVO : storeObjectlist) {
            storelist.add(new SelectItem(storehouseVO.getId(), storehouseVO.getAddressdetail()));
        }
        log.info("storeObjectlist is:{}", JSON.toJSONString(storeObjectlist));
    }

    public void findStore() {

    }

    public void findStoreUser() {
        logger.info("查询所有库管人员：{}", JSONObject.toJSONString(selectStroehouse));
        userVOS = storehouseService.findAllUser(Integer.valueOf(selectStroehouse));
        logger.info("userVOS IS ：{}", JSONObject.toJSONString(userVOS));
    }

    public void editUser() {

    }

    public void changeStatus() {
        log.info("修改 user status");
    }

    public void onRowSelect(SelectEvent event) {
        log.debug("addOrUpdateCompany onRowSelect: " + selectVO.getId());
        PrimeFaces.current().executeScript("PF('companyDialog').show()");
    }

}
