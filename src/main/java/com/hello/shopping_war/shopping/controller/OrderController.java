package com.hello.shopping_war.shopping.controller;


import com.hello.shopping_war.product.service.ProductService;
import com.hello.shopping_war.shopping.service.OrderService;
import com.hello.shopping_war.shopping.vo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/shopping")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public String index(Model model) {

        return "redirect:/product/list";
    }

    @PostMapping("/cartAdd")
    @ResponseBody
    public int cartAdd(Model model, Order pOrder) throws Exception {

       Order order = new Order();
       order.setCustomerId(pOrder.getCustomerId());
       order.setProductNumber(pOrder.getProductNumber());

        int purchaseExist = orderService.purchaseExist(order);

        int result = 0;

        if (purchaseExist > 0) {
            result = orderService.amountAdd(order);
        } else {
            result = orderService.cartAdd(order);
        }


       return result;
    }

    @PostMapping("/cartCancel")
    @ResponseBody
    public int cartCancel(Model model, Order pOrder) throws Exception {

        Order order = new Order();
        order.setCustomerId(pOrder.getCustomerId());
        order.setOrderNumber(pOrder.getOrderNumber());

        int result = orderService.cartCancel(order);

        return result;
    }

    @GetMapping("/cartList")
    public String cartList(Order order, Model model) throws Exception {

        System.out.println("customerId = " + order.getCustomerId());
        log.info("customerId = {}", order.getCustomerId());
        List<Order> cartList = orderService.cartList(order.getCustomerId());


        model.addAttribute("cartList", cartList);
        log.info("cartList = {}", cartList);

        return "shopping/cartList";
    }
}
