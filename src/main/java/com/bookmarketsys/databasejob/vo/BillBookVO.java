package com.bookmarketsys.databasejob.vo;

/**
 * @ClassName BillBookVO
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/18
 **/
public class BillBookVO {
    private String bookName;
    private String precess;
    private Double singlePrice;
    private Integer number;
    private Double amount;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrecess() {
        return precess;
    }

    public void setPrecess(String precess) {
        this.precess = precess;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
