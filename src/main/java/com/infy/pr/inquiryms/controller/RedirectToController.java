package com.infy.pr.inquiryms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectToController {

	@GetMapping("/")
	public String redirectToHome() {
		
		return "redirect:/form" ;
	}
}
