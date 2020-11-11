package edu.depaul.se452.windycityflyers.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String ret ="index";
        GrantedAuthority authority = auth.getAuthorities().stream().findFirst().get();
        if("ROLE_ADMIN".equals(authority.getAuthority())){
            ret = "redirect:/admin/";
        }else if("ROLE_RUNNER".equals(authority.getAuthority())){
            ret = "redirect:/runner/";
        }else if("ROLE_CUSTOMER".equals(authority.getAuthority())){
            ret = "redirect:/customer/";
        }
        return ret;
    }

    @GetMapping("/customer/")
    public String customerIndex(Model model) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<18;i++){
            list.add(i);
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