package com.hello.shopping_war.product.controller;

import com.hello.shopping_war.member.vo.Customer;
import com.hello.shopping_war.product.service.ProductService;
import com.hello.shopping_war.product.service.ProductServiceImpl;
import com.hello.shopping_war.product.vo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String productList(Model model) throws Exception {
        List<Product> product = productService.findProduct();

        model.addAttribute("productList", product);
        model.addAttribute("test", "크헉");

        log.info("productList = {}", product);
        return "product/productList";
    }
}
