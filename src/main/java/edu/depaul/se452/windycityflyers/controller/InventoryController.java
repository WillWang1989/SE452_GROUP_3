package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Inventory;
import edu.depaul.se452.windycityflyers.service.DepartmentService;
import edu.depaul.se452.windycityflyers.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/customer/{storeId}/inventory")
public class InventoryController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("")
    public String showAllDepartment(@PathVariable("storeId") String storeId, Model model) {
        model.addAttribute("store",storeService.findById(storeId));
        return "admin/inventory/inventory-list";
    }

    @GetMapping("/add")
    public String addStore(Model model) {
        model.addAttribute("inventory", new Inventory());
        return "admin/inventory/inventory-add";
    }

    @GetMapping("/edit")
    public String editStore(Model model) {
        model.addAttribute("inventory", new Inventory());
        return "admin/inventory/inventory-edit";
    }
}
