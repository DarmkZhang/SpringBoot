package com.hsbc.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.hsbc.demo.Validator.UserValidator;
import com.hsbc.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {
	@Autowired
	private MockMvc mvc;
    //一个小的更改
	@Test
	public void contextLoads() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/"))
		     .andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("user.userName.too_long"));
		
		mvc.perform(MockMvcRequestBuilders.get("/l"))
	     .andExpect(MockMvcResultMatchers.status().isOk())
	.andExpect(MockMvcResultMatchers.content().string("user.userName.required"));

		
	}

}
