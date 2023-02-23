package com.example.demo.server;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityExampleApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	void hello_when_unauthenticated_then_redirect() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().is3xxRedirection());
	}

	@Test
	@WithMockUser
	void hello_when_authenticated_then_ok() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk());
	}

}
