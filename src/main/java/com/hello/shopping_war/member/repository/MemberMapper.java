package com.hello.shopping_war.member.repository;

import com.hello.shopping_war.member.vo.Customer;
import com.hello.shopping_war.product.vo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    Customer loginfMemberInfo(Customer member);

}
