package com.epam.demo.controller;

import com.epam.demo.model.User;
import com.epam.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class RegisterController {

    @GetMapping(value="/register")
    public String save(){
        return "register";
    }
}
