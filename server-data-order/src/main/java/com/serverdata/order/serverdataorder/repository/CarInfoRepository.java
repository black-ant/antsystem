package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.CarInfo;
import com.serverdata.order.serverdataorder.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 15:12
 * @Version 1.0
 **/
public interface CarInfoRepository  extends JpaRepository<CarInfo, Long> {

    public List<CarInfo> findByCarId(Long carid);
}
