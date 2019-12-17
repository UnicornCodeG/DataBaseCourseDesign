package com.bookmarketsys.databasejob.vo;

/**
 * @ClassName CreateOrderVO
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/10
 **/
public class SettlementAmountVO {
    private Integer bookId;
    private Integer number;
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
