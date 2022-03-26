package com.epam.demo.controller;

import com.epam.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String login(){
        return "index";
    }
}
