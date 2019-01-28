package com.dataserver.demo.service;

import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.dto.PlatformUserDTO;
import com.dataserver.demo.repository.UserPlatformRepository;
import com.dataserver.demo.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserPlatformService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserPlatformRepository uprepository;
    @Autowired
    UserPlatformRepository userPlatformRepository;

    public List<UserPlatformEntity> getAllUser() {
        return uprepository.findAll();
    }

    /**
     * 获取平台员工列表
     * @return
     */
    public List<PlatformUserDTO> userlist() {
        LinkedList<PlatformUserDTO> dtoList = new LinkedList<>();
        List<UserPlatformEntity> userList = userPlatformRepository.findByStatusNot("0");
        for (UserPlatformEntity user : userList) {
//            dtoList.add(new PlatformUserDTO(user));
        }
        return dtoList;
    }

    /**
     * 获取单个员工信息
     * @return
     */
    public UserPlatformEntity getOneUser(Long userid){
        logger.info("获取员工信息>>>>员工ID:{}",userid);
        UserPlatformEntity user = userPlatformRepository.findByFilter("1","1");
        return user;
    }


    public boolean createPlatformUser(PlatformUserDTO platDto) {
        UserPlatformEntity user = new UserPlatformEntity(platDto);
        ObjectUtil.reflect(user);
        logger.info("userid is :{}---username is:{}",user.getUserid(),user.getUsername());
        userPlatformRepository.save(user);
        return true;
    }
}
