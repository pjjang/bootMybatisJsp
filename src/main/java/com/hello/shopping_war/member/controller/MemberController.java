package com.hello.shopping_war.member.controller;

import com.hello.shopping_war.member.service.MemberService;
import com.hello.shopping_war.member.vo.Customer;
import com.hello.shopping_war.product.service.ProductService;
import com.hello.shopping_war.product.vo.Product;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {


    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginMember(Model model,
                              @RequestParam("customerId") String customerId,
                              @RequestParam("password") String password,
                              HttpSession session) {

        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setPassword(password);

        Customer loginMember = memberService.loginfMemberInfo(customer);

        if (loginMember != null) {
            session.setAttribute("loginMember", loginMember);
            return "redirect:/product/list";
        }

        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping("/logout")
    public String logoutMember(Model model, HttpSession session) {


        if(session != null) {
            //session.removeAttribute("loginMember");
            //Session session =(Session)model.addAttribute("loginMember", session.getAttribute("loginMember"));
            session.invalidate();
        }

        return "redirect:/login?logout";
    }
}
