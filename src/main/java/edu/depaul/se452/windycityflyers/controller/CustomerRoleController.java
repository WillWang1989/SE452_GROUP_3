package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.Product;
import edu.depaul.se452.windycityflyers.model.ShoppingCart;
import edu.depaul.se452.windycityflyers.service.ProductService;
import edu.depaul.se452.windycityflyers.service.ShoppingCartService;
import edu.depaul.se452.windycityflyers.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerRoleController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;
    @GetMapping("/cart")
    public String shoppingCart(Model model){
        model.addAttribute("stores",storeService.findAll());
        ShoppingCart sc =shoppingCartService.findByCustomerUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        if(sc==null)
            sc =new ShoppingCart();
        model.addAttribute("cart",sc);
        return "/customer/shopping-cart";
    }

    @GetMapping("/product/{pid}")
    public String productDetail(@PathVariable("pid") String pid,Model model){

        ShoppingCart sc =shoppingCartService.findByCustomerUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        if(sc==null)
            sc =new ShoppingCart();
        Product p =productService.findById(pid);
        model.addAttribute("product",p);
        model.addAttribute("cart",sc);
        model.addAttribute("stores",storeService.findAll());

        return  "/customer/product-detail";
    }


}
