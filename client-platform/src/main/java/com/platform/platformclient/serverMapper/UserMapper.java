package com.platform.platformclient.serverMapper;

import com.platform.platformclient.entity.vo.ShopVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 23:09
 * @Version 1.0
 **/
@FeignClient("server-user")
public interface UserMapper {

    @PostMapping("/dep/depidfind")
    String findByDepid( @RequestParam("depid") Long depid);

    @PostMapping("/dep/alldep")
    public String findAllDep();

    @PostMapping("/dep/findgroup")
    public String findDepGroupd(@RequestParam("depid") Integer depid);
}
