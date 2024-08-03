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
    public List<Product> productList(Product product) throws Exception {
        return productMapper.productList(product);
    }

    @Override
    public Product findProduct(int productNumber) throws Exception {
        return productMapper.findProduct(productNumber);
    }

    @Override
    public int updateProduct(Product product) throws Exception {
        return productMapper.updateProduct(product);
    }

    @Override
    public int countProductList() throws Exception {
        return productMapper.countProductList();
    }
}
