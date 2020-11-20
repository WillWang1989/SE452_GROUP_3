package edu.depaul.se452.windycityflyers.controller;

import edu.depaul.se452.windycityflyers.model.ShoppingCart;
import edu.depaul.se452.windycityflyers.service.ProductService;
import edu.depaul.se452.windycityflyers.service.ShoppingCartService;
import edu.depaul.se452.windycityflyers.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @GetMapping("/")
    public String root() {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String ret ="index";
        GrantedAuthority authority = auth.getAuthorities().stream().findFirst().get();
        if("ROLE_ADMIN".equals(authority.getAuthority())){
            ret = "redirect:/admin/";
        }else if("ROLE_RUNNER".equals(authority.getAuthority())){
            ret = "redirect:/runner/";
        }else if("ROLE_CUSTOMER".equals(authority.getAuthority())){
            ret = "redirect:/customer/";
        }
        return ret;
    }

    @GetMapping("/customer/")
    public String customerIndex(@RequestParam("p") Optional<Integer> page,
                                @RequestParam("sid")Optional<Long> storeId,
                                @RequestParam("q")Optional<String> keyword,
                                @RequestParam("s")Optional<String> sort,
                                Model model) {
        int currentPage = page.orElse(1) - 1;
        String query = keyword.orElse("");
        Long sid = storeId.orElse(0L);
        String s = sort.orElse("0");
        Sort s1 = Sort.by("id").ascending();
        if("1".equals(s)){
            s1 = Sort.by("price").ascending();
        }else if("2".equals(s)){
            s1 = Sort.by("price").descending();
        }else if("3".equals(s)){
            s1 = Sort.by("id").descending();
        }
        Pageable p =  PageRequest.of(currentPage,20,s1);
        model.addAttribute("stores",storeService.findAll());
        ShoppingCart sc =shoppingCartService.findByCustomerUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        if(sc==null)
            sc =new ShoppingCart();
        model.addAttribute("cart",sc);
        model.addAttribute("products",productService.findInAllFields(sid,query,p));
        return "customer/index";
    }

    @GetMapping("/search")
    public String search() {
        return "/Search";
    }

    @GetMapping("/admin/")
    public String adminIndex() {
        return "admin/index";
    }

    @GetMapping("/runner/")
    public String runnerIndex() {
        return "runner/index";
    }

    @GetMapping("/accessdenied")
    public String accessDenied(@RequestParam("t") Optional<String> url_t, Model model) {
        String msgTmpl = "%s was trying to access protected resource that is only available to %s";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = "Authenticated USER";
        String url = url_t.orElse("");
        if(url.toLowerCase().startsWith("/admin")){
            role = "ADMIN";
        }else if(url.toLowerCase().startsWith("/runner")){
            role = "RUNNER";
        }else if(url.toLowerCase().startsWith("/customer")) {
            role = "CUSTOMER";
        }
        String msg = String.format(msgTmpl,auth.getName(),role);
        model.addAttribute("message",msg);
        return "access-denied";
    }}