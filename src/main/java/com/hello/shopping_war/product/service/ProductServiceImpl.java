package com.hello.shopping_war.product.service;


import com.hello.shopping_war.product.repository.ProductMapper;
import com.hello.shopping_war.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findProduct() {
        return productMapper.findProduct();
    }
}
