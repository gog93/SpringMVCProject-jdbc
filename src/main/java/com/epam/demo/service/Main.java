package com.epam.demo.service;

import com.epam.demo.model.User;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        User user=new User();
        user.setId(1);
        user.setName("g");
        user.setSureName("a");
        user.setAge(3);
        user.setEmail("a");
        user.setPassword("a");
        userService.create(user);
    }
}
