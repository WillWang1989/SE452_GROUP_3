package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Department;
import edu.depaul.se452.windycityflyers.model.Store;
import edu.depaul.se452.windycityflyers.service.CustomerService;
import edu.depaul.se452.windycityflyers.service.DepartmentService;
import edu.depaul.se452.windycityflyers.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/store/{storeId}/department")
public class DepartmentController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("")
    public String showAllDepartment(@PathVariable("storeId") String storeId, Model model) {
        model.addAttribute("store",storeService.findById(storeId));
        return "admin/department/department-list";
    }

    @GetMapping("/add")
    public String addDepartment(@PathVariable("storeId") String storeId,Model model) {
        model.addAttribute("store",storeService.findById(storeId));
        model.addAttribute("department", new Department());
        return "admin/department/department-add";
    }

    @GetMapping("/edit")
    public String editDepartment(@PathVariable("storeId") String storeId,Model model) {
        model.addAttribute("store",storeService.findById(storeId));
        model.addAttribute("department", new Department());
        return "admin/department/department-edit";
    }
}
