package com.morozov.springboot.crud.jm_springboot_crud_app.controller;

import com.morozov.springboot.crud.jm_springboot_crud_app.model.Role;
import com.morozov.springboot.crud.jm_springboot_crud_app.model.User;
import com.morozov.springboot.crud.jm_springboot_crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("userList")
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "all-users";
    }

    @GetMapping("addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        List<Role> roleList = userService.getAllRoles();
        model.addAttribute("newUser", user);
        model.addAttribute("roles", roleList);
        return "user-info";
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("newUser") User user, @RequestParam(value = "role", required = false) String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(userService.getRoleById(Long.parseLong(roles)));
        }
        user.setRoles(roleSet);
        if (user.getId() == null) {
            user.setPassword(passwordEncoder().encode(user.getPassword()));
            userService.saveUser(user);
        }
        userService.saveUser(user);
        return "redirect:/admin/userList";
    }

    @GetMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        List<Role> list = userService.getAllRoles();
        model.addAttribute("newUser", userService.getUser(id));
        model.addAttribute("roles", list);
        return "user-info";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin/userList";
    }

}