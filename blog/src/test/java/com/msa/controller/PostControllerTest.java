package com.msa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.post.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	final String TITLE = "test title";
	final String CONTENT = "test content";
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
    public void addPost() throws Exception {
		PostDto dto = new PostDto(TITLE, CONTENT);
		this.mockMvc.perform(post("/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(dto)))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("data")))
				.andExpect(jsonPath("$.data").exists())
				.andExpect(jsonPath("$.data.title").value(TITLE))
				.andExpect(jsonPath("$.data.content").value(CONTENT))
				.andDo(print());
	}

	@Test
	public void getPostTest() throws Exception {
		this.mockMvc.perform(
				 get("/post/{postId}", "1"))
	            .andExpect(status().isOk())
	            .andExpect(content().string(containsString("data")))
	            .andExpect(jsonPath("$.data").exists())
	            .andDo(print());
	}
}
