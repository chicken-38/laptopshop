package com.laptopshop.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptopshop.laptopshop.domain.User;
import com.laptopshop.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable() long id) {
        this.userService.getUserById(id).ifPresentOrElse(user -> model.addAttribute("user", user),
                () -> {
                    model.addAttribute("message", "User not found!");
                    model.addAttribute("user", new User());
                });
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/update")
    public String updateUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        this.userService.getUserById(user.getId()).ifPresentOrElse(currentUser -> {
            currentUser.setFullName(user.getFullName());
            currentUser.setAddress(user.getAddress());
            currentUser.setPhone(user.getPhone());
            this.userService.handleSaveUser(currentUser);
        }, () -> redirectAttributes.addFlashAttribute("message", "User update failed!"));
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/update/{id}")
    public String getMethodName(Model model, @PathVariable long id) {
        this.userService.getUserById(id).ifPresentOrElse(currentUser -> model.addAttribute("user", currentUser),
                () -> {
                    model.addAttribute("message", "User not found!");
                    model.addAttribute("user", new User());
                });
        return "admin/user/update";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(@PathVariable() long id, Model model) {
        this.userService.getUserById(id).ifPresentOrElse(currentUser -> model.addAttribute("user", currentUser),
                () -> model.addAttribute("message", "User not found!"));
        return "admin/user/detail";
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
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
        return "admin/user/show";
    }

}
