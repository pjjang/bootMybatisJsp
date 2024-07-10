package com.hello.shopping_war.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private int orderNumber;
    private String customerId;
    private int productNumber;
    private int quantity;
    private Date orderDate;
}
