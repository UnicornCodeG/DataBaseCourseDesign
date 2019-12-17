package com.bookmarketsys.databasejob.vo;

/**
 * @ClassName AddIntoShoppingCartVo
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/16
 **/
public class AddIntoShoppingCartVO {
    Integer userId;
    Integer bookId;
    Integer menuId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
}
