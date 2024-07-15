package com.hello.shopping_war.member.controller;

import com.hello.shopping_war.member.vo.Customer;
import com.hello.shopping_war.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/member")
public class MemberController {



    @PostMapping("/login")
    public String productList2(Model model,
                              @RequestParam("customerId") String customerId,
                              @RequestParam("password") String password) {

        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setPassword(password);


        return "product/productList";
    }
}
