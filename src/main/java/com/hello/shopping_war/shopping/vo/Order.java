package com.hello.shopping_war.shopping.vo;

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
    private String productName;
    private int inventory;
    private int price;
    private String manufacturer;
    private int amount;
}
