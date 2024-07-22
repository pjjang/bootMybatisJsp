package com.hello.shopping_war.shopping.service;

import com.hello.shopping_war.product.vo.Product;
import com.hello.shopping_war.shopping.vo.Order;

import java.util.List;

public interface OrderService {

    public List<Order> cartList(String customerId) throws Exception;

    int cartAdd(Order pOrder) throws Exception;

    int purchaseExist(Order order) throws Exception;

    int amountAdd(Order pOrder) throws Exception;

    int cartCancel(Order pOrder)  throws Exception;
}
