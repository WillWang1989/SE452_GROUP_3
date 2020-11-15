package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.service.RunnerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/runner")
public class RunnerController {
    @Autowired
    private RunnerReviewService runnerReviewService;
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
    public ModelAndView showRunnerReviews() {
        ModelAndView mv = new ModelAndView("runner/runner-review");
        mv.addObject("runnerreviews", runnerReviewService.findAll());
        return mv;
    }

}
