package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/customer/")
    public String customerIndex(Model model) {
        ArrayList<Product> list = new ArrayList<>();
        for(int i =0;i<18;i++){
            list.add(new Product(){});
        }
        model.addAttribute("products",list);
        return "customer/index";
    }

    @GetMapping("/search")
    public String search() { return "/Search";
    }

    @GetMapping("/admin/")
    public String adminIndex() {
        return "admin/index";
    }

    @GetMapping("/runner/")
    public String runnerIndex() {
        return "runner/index";
    }}