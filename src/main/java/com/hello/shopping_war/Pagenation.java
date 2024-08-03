package com.hello.shopping_war;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagenation {
    private int page = 1; // 보고 싶은 페이지 번호
    private int size = 10; // 한 페이지에 보여줄 항목 수
    private int offset; // 몇 번째 항목부터 시작할지
    private int count; // 전체 항목 수
    private int totalPages; // 전체 페이지 수
    private int currentPage; // 현재 페이지 번호

    // 페이지 번호와 크기를 사용해 offset을 계산
    public Pagenation(int page, int size, int count, int totalPages, int currentPage) {
        this.page = page;
        this.size = size;
        this.offset = calculateOffset(page, size);
        this.count = count;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    // offset 계산 메서드
    public int calculateOffset(int page, int size) {
        return (page - 1) * size;
    }

    // 페이지 번호를 설정할 때 offset도 계산
    public void setPage(int page) {
        this.page = page;
        this.offset = calculateOffset(page, this.size);
    }

    // 페이지 크기를 설정할 때 offset도 계산
    public void setSize(int size) {
        this.size = size;
        this.offset = calculateOffset(this.page, size);
    }
}