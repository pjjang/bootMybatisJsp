package com.hello.shopping_war.product.vo;

import com.hello.shopping_war.Pagenation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Pagenation {
    private int productNumber;
    private String productName;
    private int inventory;
    private int price;
    private String manufacturer;

}
