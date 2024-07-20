package com.hello.shopping_war.shopping.service;


import com.hello.shopping_war.product.repository.ProductMapper;
import com.hello.shopping_war.product.vo.Product;
import com.hello.shopping_war.shopping.repository.OrderMapper;
import com.hello.shopping_war.shopping.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int cartAdd(Order pOrder) throws Exception {

        int result = orderMapper.cartAdd(pOrder);

        return result;
    }


    @Override
    public List<Order> cartList(String customerId) throws Exception {
        return orderMapper.cartList(customerId);
    }

    @Override
    public int purchaseExist(Order order) throws Exception {
        return orderMapper.purchaseExist(order);
    }

    @Override
    public int amountAdd(Order order) throws Exception {
        order.setQuantity(order.getQuantity() + 1);
        return orderMapper.amountAdd(order);
    }
}
