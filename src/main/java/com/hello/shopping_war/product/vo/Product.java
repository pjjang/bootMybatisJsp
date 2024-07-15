package com.hello.shopping_war.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private int productNumber;
    private String productName;
    private int inventory;
    private int price;
    private String manufacturer;

}
