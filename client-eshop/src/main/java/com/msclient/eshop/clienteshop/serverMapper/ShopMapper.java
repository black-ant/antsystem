package com.msclient.eshop.clienteshop.serverMapper;

import com.msclient.eshop.clienteshop.entity.GoodVO;
import com.msclient.eshop.clienteshop.entity.ShopVO;
import com.msclient.eshop.clienteshop.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/31 23:00
 * @Version 1.0
 **/
@FeignClient("server-eshop")
public interface ShopMapper {

    /*
     *shop
     *
     */
    @PostMapping("/shopone")
    String shopone(@RequestParam("shopid") String shopid);

    @PostMapping("/shopedit")
    String shopEdit(@RequestBody ShopVO shopVO, @RequestParam("shopid") String shopid, @RequestParam("status") String status);

    @PostMapping("/shoppath/{status}")
    String shopPath(@RequestBody ShopVO shopVO, @RequestParam("shopid") String shopid, @PathVariable("status") String status);

    /*
     *goods
     *
     */
    @PostMapping("/savegood")
    String saveGood(GoodVO objvo);

    @PostMapping("findGoods")
    String findGoodsByShopid(@RequestParam("shopid") String shopid);

    @PostMapping("findOneGoods")
    String findGoodsByCode(@RequestParam("code") String code);

    @PostMapping("/savegood")
    String saveGoodList(List<GoodVO> objvos);

    @PostMapping("/usercart")
    List<GoodVO> getusercart(String userid);

    /*
     *shopUser
     *
     */
    @PostMapping("/user/adduser")
    String addUser(UserVO userVO);

}
