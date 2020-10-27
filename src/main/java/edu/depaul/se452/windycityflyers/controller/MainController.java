package edu.depaul.se452.windycityflyers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
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