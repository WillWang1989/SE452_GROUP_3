package edu.depaul.se452.windycityflyers.controller;


import edu.depaul.se452.windycityflyers.model.CartProducts;
import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.model.Product;
import edu.depaul.se452.windycityflyers.model.ShoppingCart;
import edu.depaul.se452.windycityflyers.service.CartProductsService;
import edu.depaul.se452.windycityflyers.service.CustomerService;
import edu.depaul.se452.windycityflyers.service.ProductService;
import edu.depaul.se452.windycityflyers.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/customer/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartProductsService cartProductsService;

    @PostMapping("/add")
    public ShoppingCart add(@RequestBody CartProducts cp) {
        Product p  = productService.findById(cp.getProduct().getId()+"");
        if(p==null) return null;
        String un = SecurityContextHolder.getContext().getAuthentication().getName();
        Customer c = customerService.findByUsername(un);
        ShoppingCart sc = shoppingCartService.findByCustomerId(c.getId());
        if (sc == null) {
            cp.setProduct(p);
            sc = new ShoppingCart();
            sc.setCustomer(c);
            sc.setProducts(new ArrayList(Arrays.asList(cp)));
            sc.setTotalCost(cp.getProduct().getPrice());
            sc = shoppingCartService.update(sc);
        } else {
            boolean hasProduct = false;
            for (CartProducts it : sc.getProducts()) {
                if (it.getProduct().getId() == cp.getProduct().getId()) {
                    cp.setProduct(it.getProduct());
                    cp.setCount(it.getCount()+1);
                    cp.setId(it.getId());
                    hasProduct = true;
                    break;
                }
            }

            if (!hasProduct) {
                cp.setProduct(p);
                sc.getProducts().add(cp);

            }
            sc.setTotalCost(sc.getTotalCost().add(cp.getProduct().getPrice()));
        }


        cp.setCart(sc);
        cartProductsService.update(cp);

        return shoppingCartService.update(sc);
    }
    @GetMapping("/")
    public ShoppingCart addGet(){
        String un = SecurityContextHolder.getContext().getAuthentication().getName();
        Customer c = customerService.findByUsername(un);
        ShoppingCart sc = shoppingCartService.findByCustomerId(c.getId());
        return sc;
    }

    @PostMapping("/update")
    public ShoppingCart update(@RequestBody CartProducts cp){
        Product p  = productService.findById(cp.getProduct().getId()+"");
        if(p==null) return null;
        String un = SecurityContextHolder.getContext().getAuthentication().getName();
        ShoppingCart sc = shoppingCartService.findByCustomerUsername(un);
        if(sc==null) return  null;
        if(cp.getCount() == 0){
            cartProductsService.deleteById(cp.getId());
        }else {
            cp.setProduct(p);
            cp.setCart(sc);
            cartProductsService.update(cp);
        }
        sc.calcTotalCost();
        return shoppingCartService.update(sc);

    }
}
