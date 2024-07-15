package com.hello.shopping_war.product.service;

import com.hello.shopping_war.product.vo.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findProduct() throws Exception;
}
