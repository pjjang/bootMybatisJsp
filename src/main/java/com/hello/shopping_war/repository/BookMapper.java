package com.hello.shopping_war.repository;

import com.hello.shopping_war.vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Product> findProduct();


}
