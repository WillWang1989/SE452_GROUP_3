package edu.depaul.se452.windycityflyers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/runner")
public class RunnerController {
    @GetMapping
    public String index(){
        return "runner/index";
    }

    @GetMapping("/orderwaitingfordelivery")
    public String orderWaitingForDelivery(){
        return "runner/order-waiting-for-delivery";
    }
    @GetMapping("/orderdeliveringbyme")
    public String orderDeliveringByme(){
        return "runner/order-delivering-by-me";
    }
    @GetMapping("/orderdeliveredbyme")
    public String orderDeliveredByme(){
        return "runner/order-delivered-by-me";
    }
    @GetMapping("/runnerreview")
    public String reviews(){
        return "runner/runner-review";
    }

}
