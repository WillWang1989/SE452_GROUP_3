package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Product;
import edu.depaul.se452.windycityflyers.model.Store;
import edu.depaul.se452.windycityflyers.service.DepartmentService;
import edu.depaul.se452.windycityflyers.service.StoreService;
import edu.depaul.se452.windycityflyers.service.ProductService;
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
@RequestMapping("/admin/store/{storeId}/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private StoreService storeService;
    @GetMapping("/productinfo/{id}")
    public String ProductInfo(@PathVariable("id") String productId,Model model) {
        model.addAttribute("product",productService.findById(productId));
        return "admin/store/product-info";
    }
    @GetMapping("")
    public ModelAndView showProducts() {
        ModelAndView mv = new ModelAndView("admin/product/product-list");
        mv.addObject("products", productService.findAll());
        return mv;
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "admin/product/product-add";
    }

    @PostMapping("/add")
    public String addStoreProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/product/product-add";
        }

        productService.update(product);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin/product/";
    }

    @GetMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") String productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "/admin/product/product-edit";
    }

    @PostMapping("/edit")
    public String updateProductPost(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/product/product-edit";
        }
        productService.update(product);
        return "redirect:/admin/product/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String productid) {
        productService.deleteById(productid);
        return "redirect:/admin/product/";
    }
}
