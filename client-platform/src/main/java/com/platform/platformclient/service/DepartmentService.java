package com.platform.platformclient.service;

import com.platform.platformclient.common.JSONUtils;
import com.platform.platformclient.entity.vo.DepartmentVO;
import com.platform.platformclient.serverMapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService extends BaseService{

    Logger logger = LoggerFactory.getLogger(getClass());

    public String findByDepid(Long depid){
        String wrapper = userMapper.findByDepid(depid);
        return wrapper;
    }

    public List<DepartmentVO> findAllDep(){
        String wrapper = userMapper.findAllDep();
        logger.info("wrapper is :{}",wrapper);
        List<DepartmentVO> list= JSONUtils.wrapperToList(wrapper,DepartmentVO.class);
        return list;
    }


}
