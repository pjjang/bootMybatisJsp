package com.hello.shopping_war.product.controller;

import com.hello.shopping_war.member.service.MemberService;
import com.hello.shopping_war.member.vo.Customer;
import com.hello.shopping_war.product.service.ProductService;
import com.hello.shopping_war.product.service.ProductServiceImpl;
import com.hello.shopping_war.product.vo.Product;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    MemberService memberService;

    @GetMapping("/list")
    public String productList(Product product, Model model, HttpSession session) throws Exception {
//        만약 필요시 로그인유저별 상품리스트 보여주기
//        if (session == null || session.getAttribute("loginMember") == null) {
//            return "redirect:/member/login";
//        }

        int totalProductList = productService.countProductList();
        int totalPage = (int)Math.ceil((double) totalProductList / product.getSize());

        product.setOffset((product.getPage() - 1) * product.getSize());
        List<Product> productList = productService.productList(product);

        log.info("totalPage = {}", totalPage);

        model.addAttribute("productList", productList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", product.getPage());

        log.info("productList = {}", product);
        return "product/productList";
    }
}
