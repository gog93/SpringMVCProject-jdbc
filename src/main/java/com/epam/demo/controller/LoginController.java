package com.epam.demo.controller;

import com.epam.demo.model.User;
import com.epam.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
