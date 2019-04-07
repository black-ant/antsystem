package com.platform.platformclient.service;

import com.platform.platformclient.common.JSONUtils;
import com.platform.platformclient.entity.vo.DepartmentVO;
import com.platform.platformclient.entity.vo.GroupVO;
import com.platform.platformclient.serverMapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class DepartmentService extends BaseService {

//    private static HashMap<String,DepartmentVO> cacheList = new ConcurrentHashMap<String,DepartmentVO>();

    Logger logger = LoggerFactory.getLogger(getClass());

    public String findByDepid(Long depid) {
        String wrapper = userMapper.findByDepid(depid);
        return wrapper;
    }

    public String createOne(DepartmentVO departmentVO) {
        String wrapper = userMapper.addOneDepartment(departmentVO);
        return wrapper;
    }

    public List<DepartmentVO> findAllDep() {
        String wrapper = userMapper.findAllDep();
        logger.info("wrapper is :{}", wrapper);
        List<DepartmentVO> list = JSONUtils.wrapperToList(wrapper, DepartmentVO.class);
//        cacheList = list;
        return list;
    }

    public List<GroupVO> findGroup(Integer depid) {
        String wrapper = userMapper.findDepGroupd(depid);
        logger.info("wrapper is :{}", wrapper);
        List<GroupVO> list = JSONUtils.wrapperToList(wrapper, GroupVO.class);
        return list;
    }

}
