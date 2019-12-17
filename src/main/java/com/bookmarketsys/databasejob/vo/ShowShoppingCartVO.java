package com.bookmarketsys.databasejob.vo;

import com.bookmarketsys.databasejob.dto.BookAndNumberDTO;

import java.util.List;

/**
 * @ClassName ShowShoppingCart
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/10
 **/
public class ShowShoppingCartVO {
    private Integer menuId;
    private String menuName;
    private List<BookAndNumberDTO> bookList;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<BookAndNumberDTO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookAndNumberDTO> bookList) {
        this.bookList = bookList;
    }
}
