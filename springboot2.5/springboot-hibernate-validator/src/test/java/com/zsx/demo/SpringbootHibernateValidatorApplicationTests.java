package com.zsx.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class SpringbootHibernateValidatorApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void contextLoads() {
	}

	@Test void t1(){
		//mockMvc.perform(MockMvcRequestBuilders.post("/b").)
	}

	/*
	 private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext context;


    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testMock() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/mock")
                        .param("name", "demo")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//        .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString()))
                .andDo(MockMvcResultHandlers.print())
        ;
    }
	 */
}
