package com.infy.pr.mf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.infy.pr.mf.model.User;
import com.infy.pr.mf.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${second.microservice.url}")
    private String secondMicroserviceUrl;
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
    
    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute User user, Model model ) {
        userService.saveUser(user);
        model.addAttribute("message", "User saved successfully in mf first microservice db ...");
      //  String secondMicroserviceUrl="http://localhost:8082/api/susers";
        restTemplate.postForObject(secondMicroserviceUrl, user, User.class);
        System.out.println(secondMicroserviceUrl);
        
        
        return "results";
    }

    
    
}

