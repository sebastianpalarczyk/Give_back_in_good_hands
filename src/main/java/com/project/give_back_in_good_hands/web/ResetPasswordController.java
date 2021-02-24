package com.project.give_back_in_good_hands.web;

import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.domain.VerificationToken;
import com.project.give_back_in_good_hands.service.EmailService;
import com.project.give_back_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResetPasswordController {

    private final UserService userService;
    private final EmailService emailService;

    public ResetPasswordController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public String serveEmail(Model model){
        model.addAttribute("user", new User());
        return "reset-password";
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public String checkEmail(@ModelAttribute User user){
        User userByEmail = userService.findUserByEmail(user.getEmail());
        if(userByEmail == null){
            return "invalid-email";
        }
        VerificationToken token = userService.findByUser(userByEmail);
        VerificationToken newToken = userService.generateNewVerificationToken(token.getToken());
        emailService.sendSimpleMessage(userByEmail.getEmail(), "Zmiana hasła do konta",
                "Link do zmiany hasła: http://localhost:8080/reset-password/"+newToken.getToken());
        return "sent-email";
    }

    @RequestMapping(value = "/reset-password/{token}", method = RequestMethod.GET)
    public String resetFormPassword(@PathVariable String token, Model model){
        VerificationToken verificationToken = userService.findByToken(token);
        User user = verificationToken.getUser();
        if(!userService.checkToken(verificationToken)){
            VerificationToken newVerificationToken = userService.generateNewVerificationToken(verificationToken.getToken());
            emailService.sendSimpleMessage(user.getEmail(), "Nowy link do zmiany hasła",
                    "Link aktywacyjny:http://localhost:8080/reset-password/"+newVerificationToken.getToken());
            return "sent-new-email";
        }
        User newUser = new User();
        newUser.setId(user.getId());
        model.addAttribute("newUser", newUser);
        return "reset-form-password";
    }

    @RequestMapping(value = "/new-password/{id}", method = RequestMethod.POST)
    public String saveNewPassword(@PathVariable Long id, @ModelAttribute User user){
        User userWithNewPassword = userService.findUserById(id);
        userWithNewPassword.setPassword(user.getPassword());
        userService.saveUser(userWithNewPassword);
        emailService.sendSimpleMessage(userWithNewPassword.getEmail(), "Zmiana hasła",
                "Witamy\n\nTwoje hasło zostało zmienione");
        return "redirect:/login";
    }
}
