package com.dataserver.demo.service;

import com.dataserver.demo.entity.UserWages;
import com.dataserver.demo.repository.UserWagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/5 12:03
 * @Version 1.0
 **/
@Service
public class UserWagesService {

    @Autowired
    UserWagesRepository wageRepo;

    public List<UserWages> findAll(){
        return wageRepo.findAll();
    }

    public UserWages findByUserid(Integer userid){
        return wageRepo.findByUserid(userid);
    }
}
