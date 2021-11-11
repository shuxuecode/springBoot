package com.zsx.demo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.zsx.demo.po.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Date;


@SpringBootTest(classes = {SpringbootHibernateValidatorApplication.class})
class SpringbootHibernateValidatorApplicationTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void t1() throws Exception {
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();


        User user = new User();
        //user.setId(1); // default message [must not be null]
        //user.setUsername("name"); // default message [用户名不能为空]
        user.setBirthday(new Date());

        String param = objectWriter.writeValueAsString(user);

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/b")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(Charset.forName("UTF-8"))
                        .content(param)
        );

        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        System.out.println("mockResponse : ");
        System.out.println(JSON.toJSONString(response, true));
        System.out.println(response.getContentAsString());
        System.out.println(response.getContentAsString(Charset.forName("UTF-8")));

    }


    @Test
    void 表单提交方式() throws Exception {

        //MultiValueMap<Object, Object> params = new MultiValueMap<>();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "2");
        params.add("username", "名字");


        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/d")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .characterEncoding(Charset.forName("UTF-8"))
                        // 第一种方式
                        //.param("id", "1")
                        //.param("elephone", "18812345678")

                        // 第二种方式
                        .params(params)
        );

        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        System.out.println("mockResponse : ");
        System.out.println(JSON.toJSONString(response, true));
        System.out.println(response.getContentAsString());
        System.out.println(response.getContentAsString(Charset.forName("UTF-8")));

    }
}
