package com.theironyard.novauc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.Column;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AngularSpringApplicationTests {

	@Autowired
	WebApplicationContext wap;

	@Autowired
	UserRepository users;

	MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}

	@Test
	public void addUser()throws Exception{
		User user = new User();
		user.setUsername("Bobby");
		user.setDateofbirth("09/12/55");
		user.setPlaceofbirth("California");
		user.setEnlistmentdate("05/30/76");
		user.setEaos("07/22/1991");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/user")
						.content(json)
						.contentType("application/json")
		);
		Assert.assertTrue(users.count() == 1);
	}
	@Test
	public void putUser()throws Exception{
		User user = new User();
		user.setId(1);
		user.setUsername("Jimmy");
		user.setDateofbirth("10/09/45");
		user.setPlaceofbirth("Georgia");
		user.setEnlistmentdate("02/14/62");
		user.setEaos("12/22/1981");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);

		mockMvc.perform(
				MockMvcRequestBuilders.put("/user")
						.content(json)
						.contentType("application/json")
		);
		Assert.assertTrue(users.count() == 1);
	}

//	@Test
//	public void getUser()throws Exception{
//		String json;
//		mockMvc.perform(MockMvcRequestBuilders.get("/user/1").accept(MediaType.TEXT_PLAIN))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.TEXT_PLAIN))
//				.andExpect(content().string("Hello World!"));
//	}

	@Test
	public void deleteUser() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/user/1")
		);
		Assert.assertTrue(users.count() == 0);
	}
}