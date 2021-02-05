package com.morozov.springboot.crud.jm_springboot_crud_app.controller;

import com.morozov.springboot.crud.jm_springboot_crud_app.model.Role;
import com.morozov.springboot.crud.jm_springboot_crud_app.model.User;
import com.morozov.springboot.crud.jm_springboot_crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("userInfo")
    public String showAllUsers(Model model, Principal principal) {
        User user = userService.getUserByName(principal.getName());
        model.addAttribute("message", "You are logged in as " + principal.getName());
        model.addAttribute("userInfo", user);
        System.out.println(userService.getAllRoles());
        List<Role> roleList = userService.getAllRoles();
        for (Role role: roleList
        ) {
            System.out.println(role);
        }
        return "user-data";
    }



}

