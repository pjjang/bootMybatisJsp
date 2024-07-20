package com.hello.shopping_war.shopping.repository;

import com.hello.shopping_war.product.vo.Product;
import com.hello.shopping_war.shopping.vo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> cartList(String customerId) throws Exception;

    int cartAdd(Order order) throws Exception;

    int purchaseExist(Order order) throws Exception;

    int amountAdd(Order order) throws Exception;

}
