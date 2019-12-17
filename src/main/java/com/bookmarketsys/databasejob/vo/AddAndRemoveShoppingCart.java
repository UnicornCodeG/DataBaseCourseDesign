package com.bookmarketsys.databasejob.vo;

/**
 * @ClassName AddAndRemoveShoppingCart
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/16
 **/
public class AddAndRemoveShoppingCart {
    private Integer bookId;
    private Integer menuId;
    private Integer number;
    private Integer userId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
