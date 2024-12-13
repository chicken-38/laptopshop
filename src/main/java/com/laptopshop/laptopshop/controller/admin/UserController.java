package com.laptopshop.laptopshop.controller.admin;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptopshop.laptopshop.domain.User;
import com.laptopshop.laptopshop.service.ImageStorageService;
import com.laptopshop.laptopshop.service.ImageStorageServiceIpml;
import com.laptopshop.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final ImageStorageService imageStorageService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService,
            ImageStorageServiceIpml imageStorageService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.imageStorageService = imageStorageService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/admin/user/delete")
    public String deleteUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        this.userService.deleteUserById(user.getId());
        redirectAttributes.addFlashAttribute("message", "Successfully deleted user!");
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable() long id) {
        this.userService.getUserById(id).ifPresentOrElse(user -> model.addAttribute("user", user),
                () -> model.addAttribute("message", "User not found!"));
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/update")
    public String updateUser(@ModelAttribute User user,
            @RequestParam("avatarFile") MultipartFile file,
            RedirectAttributes redirectAttributes) {
        this.userService.getUserById(user.getId()).ifPresentOrElse(currentUser -> {
            currentUser.setFullName(user.getFullName());
            currentUser.setAddress(user.getAddress());
            currentUser.setPhone(user.getPhone());
            String avatarName = "";
            try {
                avatarName = this.imageStorageService.storeFile(file);
                this.imageStorageService.deleteFileByName(currentUser.getAvatar());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            currentUser.setAvatar(avatarName);
            this.userService.handleSaveUser(currentUser);
            redirectAttributes.addFlashAttribute("message", "Successfully updated user!");
        }, () -> redirectAttributes.addFlashAttribute("message", "User update failed!"));
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        this.userService.getUserById(id).ifPresentOrElse(currentUser -> {
            model.addAttribute("user", currentUser);
            model.addAttribute("roles", this.userService.getAllRole());
        },
                () -> model.addAttribute("message", "User not found!"));
        return "admin/user/update";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailsPage(@PathVariable long id, Model model) {
        this.userService.getUserById(id).ifPresentOrElse(currentUser -> {
            model.addAttribute("user", currentUser);
            model.addAttribute("avatarURL", MvcUriComponentsBuilder.fromMethodName(UserController.class,
                    "readDetailFile",
                    currentUser.getAvatar() == null ? "chicken_logo.png" : currentUser.getAvatar())
                    .build().toUri().toString());
        },
                () -> model.addAttribute("message", "User not found!"));
        return "admin/user/detail";
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("message", "Hello World form Spring Boot!");
        return "hello";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", this.userService.getAllRole());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUser(@ModelAttribute User newUser,
            @RequestParam("avatarFile") MultipartFile file,
            RedirectAttributes redirectAttributes) {
        try {
            newUser.setAvatar(this.imageStorageService.storeFile(file));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        newUser.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
        this.userService.handleSaveUser(newUser);
        redirectAttributes.addFlashAttribute("message", "Successfully created user!");
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/images/{fileName}")
    @ResponseBody
    public ResponseEntity<byte[]> readDetailFile(@PathVariable String fileName) {
        try {
            byte[] bytes = this.imageStorageService.readFileContent(fileName);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        } catch (Exception exception) {
            return ResponseEntity.noContent().build();
        }

    }

}
