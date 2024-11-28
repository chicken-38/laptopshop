package com.laptopshop.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptopshop.laptopshop.domain.User;
import com.laptopshop.laptopshop.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("hello", this.userService.handleHello());
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "admin/user")
    public String getCreateUserPage() {
        return "admin/user/create";
    }

    @RequestMapping(value = "admin/user", method = RequestMethod.POST)
    public String requestMethodName(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        System.out.println(user.toString());
        redirectAttributes.addFlashAttribute("message", "Add user successfully!");
        return "redirect:/";
    }

}
