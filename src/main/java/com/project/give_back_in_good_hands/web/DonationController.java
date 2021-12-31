package com.project.give_back_in_good_hands.web;

import com.project.give_back_in_good_hands.domain.Category;
import com.project.give_back_in_good_hands.domain.Donation;
import com.project.give_back_in_good_hands.domain.Institution;
import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/app")
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService,
                              DonationService donationService, UserService userService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model, @AuthenticationPrincipal CurrentUser customUser){
        User user = customUser.getUser();
        model.addAttribute("user", user);
        model.addAttribute("donation", new Donation());
        List<Category> categories = categoryService.categories();
        model.addAttribute("categories", categories);
        List<Institution> institutions = institutionService.institutions();
        model.addAttribute("institutions", institutions);
        return "form";
    }

    @RequestMapping(value = "/form-confirmation", method = RequestMethod.POST)
    public String create(@ModelAttribute Donation donation, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        donation.prePersist();
        donation.setUser(user);
        donation.prePersist();
        donationService.save(donation);
        return "form-confirmation";
    }


    @RequestMapping(value = "/user-donation", method = RequestMethod.GET)
    public String all(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = currentUser.getUser();
        List<Donation> donations = donationService.allDonationsByUser(user);
        model.addAttribute("receivedDonations", donationService.receivedDonations(donations));
        model.addAttribute("noReceivedDonations", donationService.noReceivedDonations(donations));
        return "user-donation";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Long id, Model model){
        model.addAttribute("userUpdate", userService.findUserById(id));
        return "update-user";
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@PathVariable Long id, @ModelAttribute User user){
        User updateUser = userService.findUserById(id);
        updateUser.setEmail(user.getEmail());
        updateUser.setUsername(user.getUsername());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        if(user.getPassword().isEmpty()){
            updateUser.setPassword(updateUser.getPassword());
            userService.save(updateUser);
        }else{
            updateUser.setPassword(user.getPassword());
            userService.saveUser(updateUser);
        }
        return "Zapisano zmiany";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetails(@PathVariable Long id, Model model){
        model.addAttribute("donation", donationService.findById(id));
        return "details";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.POST)
    public String details(@PathVariable Long id, @ModelAttribute Donation donation){
        Donation receivedDonation = donationService.findById(id);
        receivedDonation.setReceived(donation.isReceived());
        receivedDonation.setDateReceived(donation.getDateReceived());
        donationService.save(receivedDonation);
        return "redirect:/app/user-donation";
    }

}
