package com.infy.pr.inquiryms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.pr.inquiryms.model.User;

@SpringBootTest
class InquiryApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void getUser() {
		
		new User().toString().substring(2);
		
	}
	

	
}
