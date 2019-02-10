package com.msclient.eshop.clienteshop.serverMapper;

import com.msclient.eshop.clienteshop.entity.GoodVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/31 23:00
 * @Version 1.0
 **/
@FeignClient("server-eshop")
public interface ShopMapper {

    @PostMapping("/shopone")
    String shopone();


    /*
     *goods
     *
     */
    @PostMapping("/savegood")
    String saveGood(GoodVO objvo);

    @PostMapping("/savegood")
    String saveGoodList(List<GoodVO> objvos);
}
