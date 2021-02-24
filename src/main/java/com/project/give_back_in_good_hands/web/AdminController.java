package com.project.give_back_in_good_hands.web;

import com.project.give_back_in_good_hands.domain.Donation;
import com.project.give_back_in_good_hands.domain.Institution;
import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.domain.VerificationToken;
import com.project.give_back_in_good_hands.service.DonationService;
import com.project.give_back_in_good_hands.service.InstitutionService;
import com.project.give_back_in_good_hands.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final InstitutionService institutionService;
    private final UserService userService;
    private final DonationService donationService;

    public AdminController(InstitutionService institutionService, UserService userService, DonationService donationService, BCryptPasswordEncoder passwordEncoder) {
        this.institutionService = institutionService;
        this.userService = userService;
        this.donationService = donationService;
    }

    @RequestMapping(value = "/home")
    public String home(){
        return "home-admin";
    }

    @RequestMapping(value = "/institutions/add", method = RequestMethod.GET)
    public String formInstitution(Model model){
        model.addAttribute("institution", new Institution());
        return "institution-add";
    }

    @RequestMapping(value = "/institutions/add", method = RequestMethod.POST)
    @ResponseBody
    public String createInstitution(@ModelAttribute Institution institution){
        institutionService.save(institution);
        return "Zapisano "+institution.getName();

    }

    @RequestMapping(value = "/institutions/{id}", method = RequestMethod.GET)
    public String formUpdate(Model model, @PathVariable Long id){
        Institution institution = institutionService.findInstitutionById(id).get();
        model.addAttribute("update", institution);
        return "institution-update";
    }

    @RequestMapping(value = "/institutions/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateFormInstitution(@PathVariable Long id, @ModelAttribute Institution institution){
        Institution institutionUpdate = institutionService.findInstitutionById(id).get();
        institutionUpdate.setName(institution.getName());
        institutionUpdate.setDescription(institution.getDescription());
        institutionService.save(institutionUpdate);
        return "Update zakończony";
    }

    @RequestMapping(value = "/institutions")
    public String allInstitutions(Model model){
        List<Institution> institutionList = institutionService.institutions();
        model.addAttribute("allInstitutions", institutionList);
        return "institutions";
    }

    @RequestMapping(value = "/institutions/delete/{id}")
    @ResponseBody
    public String deleteInstitution(@PathVariable Long id){
        Institution institution = institutionService.findInstitutionById(id).get();
        institutionService.delete(institution);
        return "Usunięto "+institution.getName();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formAdmin(Model model){
        model.addAttribute("admin", new User());
        return "admin-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String createAdmin(@ModelAttribute User user){
        userService.saveAdmin(user);
        return "Zapisano "+user.getFirstName();
    }

    @RequestMapping(value = "/admins/{id}", method = RequestMethod.GET)
    public String updateFormAdmin(Model model, @PathVariable Long id){
        User admin = userService.findUserById(id);
        model.addAttribute("updateAdmin", admin);
        return "admin-update";
    }

    @RequestMapping(value = "/admins/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateAdmin(@PathVariable Long id, @ModelAttribute User user){
        User admin = userService.findUserById(id);
        admin.setEmail(user.getEmail());
        admin.setUsername(user.getUsername());
        admin.setFirstName(user.getFirstName());
        admin.setLastName(user.getLastName());
        admin.setPassword(admin.getPassword());
        userService.save(admin);
        return "Update "+admin.getFirstName();
    }

    @RequestMapping(value = "/admins")
    public String allAdmins(Model model){
        List<User> admins = userService.findAllAdmins();
        model.addAttribute("admins", admins);
        return "admins";
    }

    @RequestMapping(value = "/admins/delete/{id}")
    @ResponseBody
    public String deleteAdmin(@PathVariable Long id){
        User user = userService.findUserById(id);
        userService.delete(user);
        return "Usunieto "+user.getFirstName();
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String formUser(Model model){
        model.addAttribute("user", new User());
        return "user-add";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "Zapisano "+user.getFirstName();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String updateFormUser(Model model, @PathVariable Long id){
           User user = userService.findUserById(id);
           model.addAttribute("updateUser", user);
           return "user-update";
    }

    @RequestMapping(value = "/users/{id}")
    @ResponseBody
    public String updateUser(@ModelAttribute User user, @PathVariable Long id){
        User updateUser = userService.findUserById(id);
        updateUser.setEmail(user.getEmail());
        updateUser.setUsername(user.getUsername());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        userService.save(updateUser);
        return "Wykonano update "+updateUser.getFirstName();
    }


    @RequestMapping(value = "/users")
    public String allUsers(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/users/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id){
        User user = userService.findUserById(id);
        VerificationToken token = userService.findByUser(user);
        userService.deleteToken(token);
        List<Donation> userDonations = donationService.allDonationsByUser(user);
        userDonations.forEach(donationService::delete);
        userService.delete(user);
        return "Usunieto "+user.getFirstName();
    }

}
