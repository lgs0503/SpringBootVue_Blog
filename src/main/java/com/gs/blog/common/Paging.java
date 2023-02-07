package com.gs.blog.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
    private int startIndex;
    private int endIndex;
    private int currentPage;
    private int rangePage;

    public Paging(int currentPage, int rangePage){
        this.currentPage = currentPage;
        this.rangePage = rangePage;

        this.startIndex = this.rangePage * (this.currentPage - 1);
        this.endIndex = this.startIndex + this.rangePage;
    }
}
