package com.platform.platformclient.service;

import com.platform.platformclient.entity.vo.DepartmentVO;
import com.platform.platformclient.serverMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends BaseService{

    public String findByDepid(Long depid){
        String wrapper = userMapper.findByDepid(depid);
        return wrapper;
    }


}
