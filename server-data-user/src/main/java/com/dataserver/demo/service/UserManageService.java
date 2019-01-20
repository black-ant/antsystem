package com.dataserver.demo.service;

import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.UserSummaryEntity;
import com.dataserver.demo.repository.UserSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/19 22:32
 * @Version 1.0
 **/
@Service
public class UserManageService {

    @Autowired
    UserSummaryRepository userSummaryRepository;


    @Transactional
    public boolean createUser(String username){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encodedPassword = passwordEncoder.encode("123456");
        UserSummaryEntity users = new UserSummaryEntity(100001,"gang","1","1",encodedPassword);
        userSummaryRepository.save(users);
        return true;
    }
}
