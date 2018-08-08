package com.example.kotesh.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.example.kotesh.demo.DemoApplication.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void testGetIndex() {
		//fail("Not yet implemented");
		try {
			mvc.perform(MockMvcRequestBuilders.get("/employee").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
	        .andExpect(content().string(equalTo("Employee Rest end point")));
		
		} catch (Exception e) {
			fail("found exception while handling testGetIndex #"+e.getMessage());
		}
	}

	@Test
	public void testGetEmployeeDetails() {
		fail("Not yet implemented");
	}

}
