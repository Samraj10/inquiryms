package com.infy.pr.mf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MfApplication {

	public static void main(String[] args) {
		SpringApplication.run(MfApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
}
