package edu.depaul.se452.windycityflyers.controller;


import edu.depaul.se452.windycityflyers.model.Payment;
import edu.depaul.se452.windycityflyers.service.PaymentService;
import edu.depaul.se452.windycityflyers.service.StoreService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/admin/customer")
    public String customer() {
        return "customer/customer-list";
    }

    @GetMapping("/admin/customer/payment/{id}")
    public String addCustomer(@PathVariable("id") String custId, Model model) {
        Payment payment = paymentService.findById(custId);
        model.addAttribute("payment", payment);
        return "customer/payment";
    }
}
