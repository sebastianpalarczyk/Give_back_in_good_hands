package com.project.give_back_in_good_hands.web;


import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.domain.VerificationToken;
import com.project.give_back_in_good_hands.service.EmailService;
import com.project.give_back_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    private final UserService userService;
    private final EmailService emailService;

    public RegisterController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user", new User());
        return"register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String create(@ModelAttribute User user){
        VerificationToken token = userService.createToken();
        userService.saveUser(user);
        userService.createVerificationTokenForUser(user, token.getToken());
        emailService.sendMessageWithAttachment(user.getEmail(),
                "Rejestracja w aplikacji odddam w dobre ręce",
                "Witamy, "+user.getFirstName()+"\n"+"\n"
                        +"fajnie, że do nas dołączyłeś! Kliknij w link aktywacyjny: http://localhost:8080/register/"+token.getToken()+"\n"
                        +"\n"
                        +"Pozdrawiamy,\n"
                        +"Zespół Oddaj w dobre ręce",
                "src/main/webapp/resources/regulamin/Regulamin.pdf");
        return "sent-email";
    }

    @RequestMapping(value = "/register/{token}", method = RequestMethod.GET)
    public String confirmationRegister(@PathVariable String token){
        VerificationToken verificationToken = userService.findByToken(token);
        boolean checkToken = userService.checkToken(verificationToken);
        User user = verificationToken.getUser();
        if(!checkToken){
            VerificationToken newVerificationToken = userService.generateNewVerificationToken(verificationToken.getToken());
            emailService.sendSimpleMessage(user.getEmail(), "Nowy link aktywacyjny",
                    "Link aktywacyjny:http://localhost:8080/register/"+newVerificationToken.getToken());
            return "sent-new-email";
        }
        userService.roleForUser(user);
        return "redirect:/login";
    }
}
