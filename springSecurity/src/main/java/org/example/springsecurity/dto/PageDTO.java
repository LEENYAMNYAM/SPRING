package org.example.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageDTO {
    private int totPage;
    private int blockPage;
    private int startPage;
    private int endPage;
    private int currentPage;
    private String searchWord;
    private String searchField;

    public PageDTO(int count, int currentPage, int pageSize){
        this.totPage = count/pageSize + (((count%pageSize)==0)?0:1);
        this.blockPage = 3;
        this.startPage = ((currentPage-1)/blockPage)*blockPage+1;
        this.endPage = startPage+blockPage-1;

        if(totPage < endPage) this.endPage = totPage;
        setStartPage(startPage);
        setEndPage(endPage);
        setTotPage(totPage);
        setBlockPage(blockPage);
        setCurrentPage(currentPage);

    }

}

