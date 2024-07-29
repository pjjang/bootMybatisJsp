package com.hello.shopping_war.shopping.repository;

import com.hello.shopping_war.product.vo.Product;
import com.hello.shopping_war.shopping.vo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    List<Order> cartList(String customerId) throws Exception;

    int cartAdd(Order order) throws Exception;

    Order purchaseExist(Order order) throws Exception;

    int cartCancel(Order order) throws Exception;

    int quantityUpdate(Order order) throws Exception;

    int orderComplete(Map<String, Object> paramMap) throws Exception;

    List<Order> orderList(int completeNumber) throws Exception;

}
