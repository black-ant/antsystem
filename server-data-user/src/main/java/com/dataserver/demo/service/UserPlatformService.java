package com.dataserver.demo.service;

import com.dataserver.demo.entity.UserPlatform;
import com.dataserver.demo.repository.UserPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPlatformService {

    @Autowired
    UserPlatformRepository uprepository;

    public List<UserPlatform> getAllUser(){
        return uprepository.findAll();
    }
}
