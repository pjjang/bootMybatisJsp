package com.hello.shopping_war.shopping.controller;


import com.hello.shopping_war.product.service.ProductService;
import com.hello.shopping_war.product.vo.Product;
import com.hello.shopping_war.shopping.service.OrderService;
import com.hello.shopping_war.shopping.vo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/shopping")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

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

        Order oldCartProduct = orderService.purchaseExist(order);

        log.info("purchaseExist = {}", oldCartProduct);
        log.info("productNumber = {}", order.getProductNumber());

        int result = 0;

        if (oldCartProduct != null) {
            result = orderService.quantityAdd(oldCartProduct);
        } else {
            result = orderService.cartAdd(order);
        }

        log.info("result = {}", result);

       return result;
    }

    @PostMapping("/quantityUpdate")
    @ResponseBody
    public int quantityUpdate(Order pOrder) throws Exception {

        Order order = new Order();
        order.setCustomerId(pOrder.getCustomerId());
        order.setProductNumber(pOrder.getProductNumber());
        order.setQuantity(pOrder.getQuantity());

        int result = orderService.quantityUpdate(order);

        log.info("result = {}", result);

        return result;
    }

    @PostMapping("/cartCancel")
    @ResponseBody
    public int cartCancel(Order pOrder) throws Exception {

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

    @PostMapping("/orderComplete")
    @ResponseBody
    public int orderComplete(@RequestParam String customerId,
                             @RequestParam List<String> orderNumbers,
                             @RequestParam String completeNumber) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("customerId", customerId);
        paramMap.put("orderNumbers", orderNumbers);
        paramMap.put("completeNumber", completeNumber);

        log.info("orderNumbers = {}", orderNumbers);
        log.info("completeNumber = {}", completeNumber);

        int result = orderService.orderComplete(paramMap);


        if(result > 0) {
            List<Order> orderProduct = orderService.orderList(Integer.parseInt(completeNumber));

            for (Order order : orderProduct) {
                int productNumber = order.getProductNumber();
                Product product = productService.findProduct(productNumber);
                log.info("productList = {}", product);

                int updateInventory = product.getInventory() - order.getQuantity();

                Product updateProduct = new Product();

                updateProduct.setInventory(updateInventory);
                updateProduct.setProductNumber(productNumber);

                productService.updateProduct(updateProduct);

            }
        }

        log.info("orderCompleteResult = {}", result);

        return result;

    }
}
