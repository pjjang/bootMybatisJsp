package com.hello.shopping_war.shopping.service;


import com.hello.shopping_war.product.repository.ProductMapper;
import com.hello.shopping_war.product.vo.Product;
import com.hello.shopping_war.shopping.repository.OrderMapper;
import com.hello.shopping_war.shopping.vo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
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
    public Order purchaseExist(Order order) throws Exception {
        return orderMapper.purchaseExist(order);
    }

    @Override
    public int quantityAdd(Order order) throws Exception {

        order.setQuantity(order.getQuantity() + 1);
        return orderMapper.quantityUpdate(order);
    }

    @Override
    public int cartCancel(Order order) throws Exception {
        return orderMapper.cartCancel(order);
    }

    @Override
    public int quantityUpdate(Order order) throws Exception {
        return orderMapper.quantityUpdate(order);
    }

    @Override
    public int orderComplete(Map<String, Object> paramMap)  throws Exception {
        return orderMapper.orderComplete(paramMap);
    }


}
