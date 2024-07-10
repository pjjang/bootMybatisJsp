package com.hello.shopping_war.service;

import com.hello.shopping_war.repository.BookMapper;
import com.hello.shopping_war.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Product> findProduct() {
        return bookMapper.findProduct();
    }
}
