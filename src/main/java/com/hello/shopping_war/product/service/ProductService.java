package com.hello.shopping_war.product.service;

import com.hello.shopping_war.product.vo.Product;

import java.util.List;

public interface ProductService {

    public List<Product> productList() throws Exception;

    public Product findProduct(int productNumber) throws Exception;

    public int updateProduct(Product product) throws Exception;
}
