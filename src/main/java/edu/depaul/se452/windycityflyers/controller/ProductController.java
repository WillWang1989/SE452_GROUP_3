package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Product;
import edu.depaul.se452.windycityflyers.model.ProductImg;
import edu.depaul.se452.windycityflyers.model.Store;
import edu.depaul.se452.windycityflyers.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
    private StorageService storageService;
    @Autowired
    private ProductImgService productImgService;


    @GetMapping("/productinfo/{id}")
    public String ProductInfo(@PathVariable("id") String productId, Model model) {
        model.addAttribute("product", productService.findById(productId));
        return "admin/store/product-info";
    }

    @GetMapping("")
    public ModelAndView showProducts(@PathVariable("storeId") String storeId) {
        ModelAndView mv = new ModelAndView("admin/product/product-list");
        mv.addObject("store", storeService.findById(storeId));
        return mv;
    }

    @GetMapping("/add")
    public String addProduct(@PathVariable("storeId") String storeId, Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("store", storeService.findById(storeId));
        return "admin/product/product-add";
    }

    @PostMapping("/add")
    public String addStoreProduct(@PathVariable("storeId") String storeId,
                                  @Valid Product product, BindingResult result, Model model) {
        model.addAttribute("store", storeService.findById(storeId));
        if (product.getDept().getId() == 0) {
            result.rejectValue("dept", null, "your must select one department");
        }
        if (result.hasErrors()) {
            return "admin/product/product-add";
        }


        productService.update(product);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin/store/" + storeId + "/product";
    }

    @GetMapping("/edit/{id}")
    public String updateProduct(@PathVariable("storeId") String storeId, @PathVariable("id") String productId,
                                Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("store", storeService.findById(storeId));
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("product", product);
        return "/admin/product/product-edit";
    }

    @PostMapping("/edit")
    public String updateProductPost(@PathVariable("storeId") String storeId,
                                    @Valid Product product, BindingResult result, Model model) {
        model.addAttribute("store", storeService.findById(storeId));
        model.addAttribute("departments", departmentService.findAll());
        if (product.getDept().getId() == 0) {
            result.rejectValue("dept", null, "your must select one department");
        }
        if (result.hasErrors()) {
            return "/admin/product/product-edit";
        }
        productService.update(product);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin/store/" + storeId + "/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("storeId") String storeId,
                         @PathVariable("id") String productid,
                         Model model) {
        productService.deleteById(productid);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin/store/" + storeId + "/product";
    }

    @GetMapping("/{id}/upload")
    public String uploadPicture(@PathVariable("storeId") String storeId,
                                @PathVariable("id") String productid, Model model) {
        model.addAttribute("store", storeService.findById(storeId));
        model.addAttribute("product", productService.findById(productid));
        model.addAttribute("file", new Object());
        return "admin/product/product-img";

    }

    @PostMapping("/{id}/upload")
    public String handleFileUpload(@RequestParam("file") @Valid MultipartFile file,
                                   @PathVariable("storeId") String storeId,
                                   @PathVariable("id") String productId,
                                   RedirectAttributes redirectAttributes,
                                   Model model) {
        Product p = productService.findById(productId);
        model.addAttribute("store", storeService.findById(storeId));
        model.addAttribute("product", p);
        if (file == null || file.isEmpty() || file.getSize() == 0) {
            redirectAttributes.addFlashAttribute("message", "Please click on the region and select an image");
        } else {
            String filename = storageService.store(file);
            productImgService.update(new ProductImg(0, p, "/uploaded/" + filename, ""));
        }
        return "redirect:/admin/store/" + storeId + "/product/" + productId + "/upload";
    }

    @GetMapping("{id}/delimg/{imgId}")
    public String deleteImage(@PathVariable("storeId") String storeId,
                              @PathVariable("id") String productId,
                              @PathVariable("imgId") String imgId,
                              Model model){
        Product p = productService.findById(productId);
        model.addAttribute("store", storeService.findById(storeId));
        model.addAttribute("product", p);
        productImgService.deleteById(imgId);
        return "redirect:/admin/store/" + storeId + "/product/" + productId + "/upload";
    }

}
