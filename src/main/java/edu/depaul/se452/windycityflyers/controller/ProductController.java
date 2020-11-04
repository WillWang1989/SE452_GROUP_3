package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Product;
import edu.depaul.se452.windycityflyers.model.Store;
import edu.depaul.se452.windycityflyers.service.DepartmentService;
import edu.depaul.se452.windycityflyers.service.ProductService;
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
@RequestMapping("/admin/store/{storeId}/product")
public class ProductController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/productinfo/{id}")
    public String ProductInfo(@PathVariable("id") String productId,Model model) {
        model.addAttribute("product",productService.findById(productId));
        return "admin/store/product-info";
    }
    @GetMapping("")
    public ModelAndView showProducts(@PathVariable("storeId") String storeId) {
        ModelAndView mv = new ModelAndView("admin/product/product-list");
        mv.addObject("store",storeService.findById(storeId));
        mv.addObject("products", productService.findAll());
        return mv;
    }

    @GetMapping("/add")
    public String addProduct(@PathVariable("storeId") String storeId,Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("store",storeService.findById(storeId));
        model.addAttribute("departments",departmentService.findAll());
        return "admin/product/product-add";
    }

    @PostMapping("/add")
    public String addStoreProduct(@PathVariable("storeId") String storeId,
				@Valid Product product, BindingResult result, Model model) {
        model.addAttribute("store",storeService.findById(storeId));
        model.addAttribute("departments",departmentService.findAll());
        if(product.getDept().getId()==0){
            result.rejectValue("dept",null,"your must select one department");
        }
        if (result.hasErrors()) {
            return "admin/product/product-add";
        }


        productService.update(product);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin/store/"+storeId+"/product";
    }

    @GetMapping("/edit/{id}")
    public String updateProduct(@PathVariable("storeId") String storeId,@PathVariable("id") String productId,
                                Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("store",storeService.findById(storeId));
        model.addAttribute("departments",departmentService.findAll());
        model.addAttribute("product", product);
        return "/admin/product/product-edit";
    }

    @PostMapping("/edit")
    public String updateProductPost(@PathVariable("storeId") String storeId,
                                    @Valid Product product, BindingResult result, Model model) {
        model.addAttribute("store",storeService.findById(storeId));
        model.addAttribute("departments",departmentService.findAll());
        if(product.getDept().getId()==0){
            result.rejectValue("dept",null,"your must select one department");
        }
        if (result.hasErrors()) {
            return "/admin/product/product-edit";
        }
        productService.update(product);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin/store/"+storeId+"/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("storeId") String storeId,
                         @PathVariable("id") String productid,
                         Model model) {
        productService.deleteById(productid);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin/store/"+storeId+"/product";
    }
    @GetMapping("/{id}/upload")
    public String uploadPicture(@PathVariable("storeId") String storeId,
                                @PathVariable("id") String productid,Model model){
        model.addAttribute("store",storeService.findById(storeId));
        model.addAttribute("product",productService.findById(productid));
        return "admin/product/product-img";

    }

}
