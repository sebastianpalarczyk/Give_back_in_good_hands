package com.project.give_back_in_good_hands.web;

import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.service.EmailService;
import com.project.give_back_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    private final UserService userService;
    private final EmailService emailService;

    public RegisterController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return"register";
    }

    @PostMapping(value = "/register")
    public String create(@ModelAttribute User user){
        userService.saveUser(user);
        emailService.sendMessageWithAttachment(user.getEmail(),
                "Rejestracja w aplikacji odddam w dobre ręce",
                "Witamy, "+user.getFirstName()+"\n"+"\n"
                        +"fajnie, że do nas dołączyłeś!\n"
                        +"\n"
                        +"Pozdrawiamy,\n"
                        +"Zespół Oddaj w dobre ręce",
                "/home/sebastian/Pulpit/Regulamin.pdf");
        return "redirect:login";
    }
}
