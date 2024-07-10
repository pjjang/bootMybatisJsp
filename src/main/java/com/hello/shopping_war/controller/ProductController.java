package com.hello.shopping_war.controller;

import com.hello.shopping_war.service.BookService;
import com.hello.shopping_war.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    BookService bookService;

    @GetMapping("/list")
    public String productList(Model model) {
        List<Product> product = bookService.findProduct();
        model.addAttribute("product", product);
        return "index";
    }
}
