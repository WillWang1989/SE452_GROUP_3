package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.dto.CustomerRegistrationDto;
import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class CustomerRegistrationController {

    @Autowired
    private CustomerService userService;

    @ModelAttribute("user")
    public CustomerRegistrationDto userRegistrationDto() {
        return new CustomerRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid CustomerRegistrationDto userDto,
                                      BindingResult result) {

        Customer existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }
}