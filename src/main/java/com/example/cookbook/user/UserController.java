package com.example.cookbook.user;

import com.example.cookbook.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final String subscribe = "subscribe";
    private final String login = "login";
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

    @GetMapping("/login-or-subscribe")
    public String loginOrSubscribe(Model model) {
        UserDto userDto = new UserDto();
        List<UsersListDto> users = userService.loadUsers();
        model.addAttribute("validateLogin", userDto);
        model.addAttribute("subscribe", subscribe);
        model.addAttribute("login", login);
        model.addAttribute("usersList", users);
        return "userLoginOrSubscribe";
    }

    @PostMapping("/login-or-subscribe")
    public String loginOrSubscribeVerify(UserDto userDto, Model model, @RequestParam(value = "action") String action) {
        String attribute = userService.validateLogin(userDto.getLoginName(), userDto.getPassword(), action);
        model.addAttribute("info", attribute);
        return "addOrEditSuccess";
    }
}