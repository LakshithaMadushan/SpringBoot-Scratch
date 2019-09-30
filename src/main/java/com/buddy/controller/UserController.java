package com.buddy.controller;

import com.buddy.channel.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // @Controller - error resolving template
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers_WithGetForEntity")
    public String getAllUsers_WithGetForEntity() throws Exception
    {
        return userService.getAllUsers_WithGetForEntity();
    }
}
