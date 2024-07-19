package com.hello.shopping_war.member.service;


import com.hello.shopping_war.member.repository.MemberMapper;
import com.hello.shopping_war.member.vo.Customer;
import com.hello.shopping_war.product.repository.ProductMapper;
import com.hello.shopping_war.product.service.ProductService;
import com.hello.shopping_war.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Customer loginfMemberInfo(Customer member) {
        return memberMapper.loginfMemberInfo(member);
    }
}


