package com.hello.shopping_war.product.repository;

import com.hello.shopping_war.product.vo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product findProduct(int productNumber);

    List<Product> productList();

    int updateProduct(Product product);


}
