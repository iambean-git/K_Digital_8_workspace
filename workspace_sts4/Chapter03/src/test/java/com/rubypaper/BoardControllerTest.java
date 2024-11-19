package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.rubypaper.domain.BoardVO;
//import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@WebMvcTest
@AutoConfigureMockMvc
public class BoardControllerTest {

//	@Autowired
//	private MockMvc mockMvc;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스터", board.getWriter());
		
//		String result = restTemplate.getForObject("/hello?name=둘리", String.class);
//		assertEquals("Hello : 둘리", result);
		
//		mockMvc.perform(get("/hello").param("name","둘리"))
//		.andExpect(status().isOk())		//isOK() : 200 (응답상태코드가 정상적인 처리인지)
//		.andExpect(content().string("Hello : 둘리"))
//		.andDo(print());
	}
}
