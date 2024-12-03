package com.laptopshop.laptopshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptopshop.laptopshop.domain.User;
import com.laptopshop.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(@PathVariable() long id, Model model) {
        Optional<User> userOptional = this.userService.getUserById(id);
        userOptional.ifPresentOrElse(value -> {
            model.addAttribute("user", value);
            System.out.println(value);
        },
                () -> {
                    model.addAttribute("message", "User not found!");
                    model.addAttribute("id", id);
                });
        return "admin/user/show";
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        // List<User> arrUsers = this.userService.getAllUsersByEmail("1@gmail.com");
        model.addAttribute("message", "Hello World form Spring Boot!");
        return "hello";
    }

    @GetMapping("admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("admin/user/create")
    public String createUser(@ModelAttribute("newUser") User newUser) {
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

}
