package com.example.cookbook.user;

import com.example.cookbook.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    UserService userService;
    CategoryService categoryService;

    public UserController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/user-form/add")
    public String createUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("editUser", userDto);
        return "userForm";
    }

    @PostMapping("/user-form/edit")
    public String editUser(UserDto userDto, Model model) {
        String attribute = userService.userCreated(userDto);
        model.addAttribute("info", attribute);
        return "addOrEditSuccess";
    }
}