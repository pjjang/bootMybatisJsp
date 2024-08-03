package com.hello.shopping_war;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagenation {
    private int page = 1;
    private int size = 10;
    private int offset;
    private int totalPages;
    private int currentPage;

}
