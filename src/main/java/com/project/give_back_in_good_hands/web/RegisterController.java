package com.project.give_back_in_good_hands.web;

import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.repository.RoleRepository;
import com.project.give_back_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return"register";
    }

    @PostMapping(value = "/register")
    public String create(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:login";
    }
}
