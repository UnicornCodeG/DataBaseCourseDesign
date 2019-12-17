package com.bookmarketsys.databasejob.vo;

/**
 * @ClassName RemoveShoppingCartVO
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/10
 **/
public class RemoveShoppingCartVO {
    private Integer userId;
    private Integer menuId;
    private Integer bookId;
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public RemoveShoppingCartVO setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public RemoveShoppingCartVO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public RemoveShoppingCartVO setMenuId(Integer menuId) {
        this.menuId = menuId;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public RemoveShoppingCartVO setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }
}
