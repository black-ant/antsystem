package com.serversearch.demo.repository;

import com.serversearch.demo.entity.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/10 18:09
 * @Version 1.0
 **/
@Component
public interface GoodsInfoRepository extends ElasticsearchRepository<GoodsInfo, Integer> {


}
