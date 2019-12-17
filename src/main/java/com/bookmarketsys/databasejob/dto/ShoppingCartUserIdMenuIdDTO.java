package com.bookmarketsys.databasejob.dto;

/**
 * @ClassName ShoppingCartUserIdMenuIdDTO
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/10
 **/
public class ShoppingCartUserIdMenuIdDTO {
    private Integer bookId;
    private Integer number;

    public Integer getBookId() {
        return bookId;
    }

    public ShoppingCartUserIdMenuIdDTO setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public ShoppingCartUserIdMenuIdDTO setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
