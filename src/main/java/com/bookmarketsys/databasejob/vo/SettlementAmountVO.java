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
    private Integer menuId;
    private Double singlePrice;//单价

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
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
