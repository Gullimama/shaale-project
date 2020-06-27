package com.realengagement.homeschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/inbox")
    public String inbox(Model model) {
        return "inbox";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
    	return "login"; 
    }

}
