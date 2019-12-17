package com.bookmarketsys.databasejob.dto;

import com.bookmarketsys.databasejob.pojo.Book;

/**
 * @ClassName BookAndNumber
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/16
 **/
public class BookAndNumberDTO {
    private Book book;
    private Integer number;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
