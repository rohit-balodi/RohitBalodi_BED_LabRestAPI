package com.greatlearning.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeRedirector {
	
	@RequestMapping("/")
    public String redirectToHomePage() {
        return "redirect:/collegefest/students";
    }

}
