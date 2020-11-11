package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin/logs")
public class LogsController {

    @Autowired
    private LogsService logsService;
    @GetMapping("")
    public ModelAndView showLogs(@RequestParam("page") Optional<Integer> page,@RequestParam("q") Optional<String> query) {
        int currentPage = page.orElse(1) - 1;
        String q = query.orElse("");
        ModelAndView mv = new ModelAndView("admin/logs/logs-list");
        Pageable p =  PageRequest.of(currentPage,20, Sort.Direction.DESC,"requestDate");
        mv.addObject("logs", logsService.findInAllFields(q,p));
        mv.addObject("q",q);
        return mv;
    }

}
