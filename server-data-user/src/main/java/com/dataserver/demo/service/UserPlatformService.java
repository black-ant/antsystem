package com.dataserver.demo.service;

import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.dto.PlatformUserDTO;
import com.dataserver.demo.repository.UserPlatformRepository;
import com.dataserver.demo.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserPlatformService {

    @Autowired
    UserPlatformRepository uprepository;
    @Autowired
    UserPlatformRepository userPlatformRepository;

    public List<UserPlatformEntity> getAllUser() {
        return uprepository.findAll();
    }


    public List<PlatformUserDTO> userlist() {
        LinkedList<PlatformUserDTO> dtoList = new LinkedList<>();
        List<UserPlatformEntity> userList = userPlatformRepository.findByStatusNot("0");
        for (UserPlatformEntity user : userList) {
//            dtoList.add(new PlatformUserDTO(user));
        }
        return dtoList;
    }

    public boolean createPlatformUser(PlatformUserDTO platDto) {
        UserPlatformEntity user = new UserPlatformEntity();
        ObjectUtil.copyData(user, platDto);
        ObjectUtil.reflect(user);
        userPlatformRepository.save(user);
        return true;
    }
}
