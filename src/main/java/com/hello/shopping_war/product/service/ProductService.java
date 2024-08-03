package com.hello.shopping_war.product.service;

import com.hello.shopping_war.product.vo.Product;

import java.util.List;

public interface ProductService {

    List<Product> productList(Product product) throws Exception;

    Product findProduct(int productNumber) throws Exception;

    int updateProduct(Product product) throws Exception;

    int countProductList() throws Exception;
}
