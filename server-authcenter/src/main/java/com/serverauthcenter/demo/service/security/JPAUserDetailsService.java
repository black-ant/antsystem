package com.serverauthcenter.demo.service.security;

import com.serverauthcenter.demo.entity.UserSummaryEntity;
import com.serverauthcenter.demo.repository.UserSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/17 22:46
 * @Version 1.0
 **/
@Service
public class JPAUserDetailsService implements UserDetailsService {
    @Autowired
    private UserSummaryRepository userSummaryRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSummaryEntity user = userSummaryRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
