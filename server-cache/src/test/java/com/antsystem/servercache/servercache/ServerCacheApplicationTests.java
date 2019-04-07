package com.antsystem.servercache.servercache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerCacheApplicationTests {

    @Autowired
    private org.springframework.web.context.WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void before() {
        //可以对所有的controller来进行测试
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


//    @Test
    public void contextLoads() {
    }

//    @Test
    public void mongotest() throws Exception {
        String uri = "/testCreate";
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    }

}
