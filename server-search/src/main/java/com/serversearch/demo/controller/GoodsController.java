package com.serversearch.demo.controller;

import com.serversearch.demo.entity.GoodsInfo;
import com.serversearch.demo.repository.GoodsInfoRepository;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/10 18:11
 * @Version 1.0
 **/
@RestController
public class GoodsController {


    @Autowired
    private GoodsInfoRepository goodsInfoRepo;

    //http://localhost:8888/save
    @GetMapping("save")
    public String save(GoodsInfo goodsInfo) {
        goodsInfoRepo.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/delete?id=1525415333329
    @GetMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        goodsInfoRepo.deleteById(id);
        return "success delete id " + id;
    }

    @GetMapping("update")
    public String update(Integer id, String alias, String goodscode, Date createDate, String goodstitle, String summary) {
        GoodsInfo goodsInfo = new GoodsInfo(id, alias, goodscode, createDate, goodstitle, summary);
        goodsInfoRepo.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/getOne?id=1525417362754
    @GetMapping("getOne")
    public GoodsInfo getOne(Integer id) {
        GoodsInfo goodsInfo = goodsInfoRepo.findById(id).get();
        return goodsInfo;
    }


    //每页数量
    private Integer PAGESIZE = 10;

    //http://localhost:8888/getGoodsList?query=商品
    //http://localhost:8888/getGoodsList?query=商品&pageNumber=1
    //根据关键字"商品"去查询列表，name或者description包含的都查询
    @GetMapping("getGoodsList")
    public List<GoodsInfo> getList(Integer pageNumber, String query) {
        if (pageNumber == null) pageNumber = 0;
        //es搜索默认第一页页码是0
        SearchQuery searchQuery = getEntitySearchQuery(pageNumber, PAGESIZE, query);
        Page<GoodsInfo> goodsPage = goodsInfoRepo.search(searchQuery);
        return goodsPage.getContent();
    }


    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                //设置权重分 求和模式
                .scoreMode("sum")
                //设置权重分最低分
                .setMinScore(10);

        // 设置分页
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }
}
