package com.infy.pr.inquiryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InquiryApplication.class, args);
		

	}

	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	
	
	
}
