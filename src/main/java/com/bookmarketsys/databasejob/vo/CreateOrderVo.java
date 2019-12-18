package com.bookmarketsys.databasejob.vo;

import java.util.List;

/**
 * @ClassName CreateOrderVo
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/12
 **/
public class CreateOrderVo {
    private List<SettlementAmountVO> settlementAmountVO;
    private Double amount;//整个订单的总价
    private Integer userId;
    private String note;


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<SettlementAmountVO> getSettlementAmountVO() {
        return settlementAmountVO;
    }

    public void setSettlementAmountVO(List<SettlementAmountVO> settlementAmountVO) {
        this.settlementAmountVO = settlementAmountVO;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
