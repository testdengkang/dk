package com;

import com.DemoApplication;
import com.example.demo.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp(){
		//两种创建MockMvc的方法
		// 前者适合一个或多个手工创建配置的控制器，
		// 后者是通过spring上下文来创建MockMvc，上下文字包含一个或多个配置的控制器
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
		//		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void contextLoads() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
		// .andExpect(status().isOk()).
		// andExpect(content().string(equalTo("hello world")));
		RequestBuilder request = null;
		request = get("/userList");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

		request = post("/addUser").param("id","111").param("name","meadow");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));

//		request = get("/userList");
//		mvc.perform(request).andExpect(status().isOk()).andDo(print());

		request = get("/getUser/{0}","111");
		mvc.perform(request).andExpect(status().isOk()).andDo(print());

		request = delete("/deleteUser/{0}","111");
		mvc.perform(request).andExpect(status().isOk()).andDo(print());

		request = put("/updateUser").param("id","111").param("name","fresh");
		mvc.perform(request).andExpect(status().isOk()).andDo(print());

		request = get("/userList");
		resultHander((MockHttpServletRequestBuilder) request);

	}

	public void resultHander(MockHttpServletRequestBuilder request) throws Exception {
		mvc.perform(request).andExpect(status().isOk()).andDo(print());
	}










}
