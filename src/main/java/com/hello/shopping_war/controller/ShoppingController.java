package com.hello.shopping_war.controller;


import com.hello.shopping_war.service.BookService;
import com.hello.shopping_war.vo.Product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class ShoppingController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> product = bookService.findProduct();
        model.addAttribute("product", product);
        return "index";
    }
}
