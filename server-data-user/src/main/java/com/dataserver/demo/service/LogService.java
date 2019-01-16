package com.dataserver.demo.service;

import com.dataserver.demo.entity.UserSummaryEntity;
import com.dataserver.demo.entity.dto.UserLoginDTO;
import com.dataserver.demo.repository.UserResourceRepository;
import com.dataserver.demo.repository.UserSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/13 22:27
 * @Version 1.0
 **/

@Service
public class LogService {

    @Autowired
    UserResourceRepository userResourceRepository;
    @Autowired
    UserSummaryRepository userSummaryRepository;

    public UserLoginDTO userToLogin(String userid) {
        UserSummaryEntity user = findUser(userid);
        return  new UserLoginDTO();
    }

    /**
     * 查找user基本信息，并且判断User是否存在
     *
     * @return
     */
    private UserSummaryEntity findUser(String userid) {
        UserSummaryEntity user = userSummaryRepository.findByUserid(userid);
        return null == user ? new UserSummaryEntity() : user;
    }
}
