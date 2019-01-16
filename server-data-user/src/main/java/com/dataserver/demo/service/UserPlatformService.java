package com.dataserver.demo.service;

import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.repository.UserPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPlatformService {

    @Autowired
    UserPlatformRepository uprepository;

    public List<UserPlatformEntity> getAllUser(){
        return uprepository.findAll();
    }
}
