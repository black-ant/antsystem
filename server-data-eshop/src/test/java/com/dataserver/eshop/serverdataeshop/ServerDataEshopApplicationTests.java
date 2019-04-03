package com.dataserver.eshop.serverdataeshop;

import com.alibaba.fastjson.JSON;
import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyKey;
import com.dataserver.eshop.serverdataeshop.entity.UserShop;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerAddressVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServerDataEshopApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();  //构造MockMvc
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void saveShopUser() throws Exception {
        UserShop shopUser = new UserShop();
        shopUser.setUserid(1);
        shopUser.setRemarks("备注");
        shopUser.setUserdesc("描述");

        String jsonData = JSON.toJSONString(shopUser);
        String responseString = mockMvc.perform(post("/user/adduserno")
                .content(jsonData).contentType(MediaType.APPLICATION_JSON)) // json 参数和类型
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
    }

    @Test
    public void saveShopUserContentType() throws Exception {
        UserShop shopUser = new UserShop();
        shopUser.setUserid(1);
        shopUser.setRemarks("备注");
        shopUser.setUserdesc("描述");

        String jsonData = JSON.toJSONString(shopUser);
        String responseString = mockMvc.perform(post("/user/adduserno")
                .content(jsonData)) // json 参数和类型
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
    }

    @Test
    public void saveShopUserForm() throws Exception {
        MultiValueMap<String,String> shopUser = new LinkedMultiValueMap<>();
        shopUser.add("userid","1");
        shopUser.add("remarks","备注");
        shopUser.add("userdesc","描述");

        String responseString = mockMvc.perform(post("/user/adduserno")
                .params(shopUser))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
    }

    List<CustomerAddressVO> list = Arrays.asList(new CustomerAddressVO(1, "阿龙"),
            new CustomerAddressVO( 2,"小花"),
            new CustomerAddressVO( 3,"阿浪"));
    @Test
    public void listToMapByObjectValue(){
        // value 为对象 student -> student jdk1.8返回当前对象
        Map<Integer, CustomerAddressVO> map = list.stream().collect(Collectors.toMap(CustomerAddressVO::getId, student -> student));
        // 遍历打印结果
        map.forEach((key, value) -> {
            System.out.println("key: " + key + "    value: " + value);
        });
    }

}

