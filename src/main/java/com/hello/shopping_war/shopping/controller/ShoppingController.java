package com.hello.shopping_war.shopping.controller;


import com.hello.shopping_war.product.service.ProductService;
import com.hello.shopping_war.product.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class ShoppingController {

    //@Autowired
    //ProductService productService;

    @GetMapping("")
    public String index(Model model) {

        return "index";
    }
}
