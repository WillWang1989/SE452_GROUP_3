package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Store;
import edu.depaul.se452.windycityflyers.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @GetMapping("/storeinfo/{id}")
    public String StoreInfo(@PathVariable("id") String storeId,Model model) {
        model.addAttribute("store",storeService.findById(storeId));
        return "admin/store/store-info";
    }

    @GetMapping("")
    public ModelAndView showStores() {
        ModelAndView mv = new ModelAndView("admin/store/store-list");
        mv.addObject("stores", storeService.findAll());
        return mv;
    }

    @GetMapping("/add")
    public String addStore(Model model) {
        model.addAttribute("store", new Store());
       return "admin/store/store-add";
    }
    @PostMapping("/add")
    public String addStorePost(@Valid Store store, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/store/store-add";
        }

        storeService.update(store);
        model.addAttribute("stores", storeService.findAll());
        return "redirect:/admin/store/";
    }

    @GetMapping("/edit/{id}")
    public String updateStore(@PathVariable("id") String storeId, Model model) {
        Store store = storeService.findById(storeId);
        model.addAttribute("store",store);
        return "/admin/store/store-edit";
    }


    @PostMapping("/edit")
    public String updateStorePost(@Valid Store store, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/store/store-edit";
        }
        storeService.update(store);
        return "redirect:/admin/store/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String storeid) {
        storeService.deleteById(storeid);
        return "redirect:/admin/store/";
    }

}
