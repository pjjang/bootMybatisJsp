package com.hello.shopping_war.shopping.service;

import com.hello.shopping_war.product.vo.Product;
import com.hello.shopping_war.shopping.vo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    public List<Order> cartList(String customerId) throws Exception;

    int cartAdd(Order pOrder) throws Exception;

    Order purchaseExist(Order order) throws Exception;

    int quantityAdd(Order pOrder) throws Exception;

    int cartCancel(Order pOrder)  throws Exception;

    int quantityUpdate(Order pOrder) throws Exception;

    int orderComplete(Map<String, Object> paramMap) throws Exception;
}
