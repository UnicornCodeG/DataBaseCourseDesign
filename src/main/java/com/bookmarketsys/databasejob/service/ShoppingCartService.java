package com.bookmarketsys.databasejob.service;

import com.bookmarketsys.databasejob.pojo.Bill;
import com.bookmarketsys.databasejob.vo.BillBookVO;
import com.bookmarketsys.databasejob.vo.CreateOrderVo;
import com.bookmarketsys.databasejob.vo.SettlementAmountVO;
import com.bookmarketsys.databasejob.vo.ShowShoppingCartVO;

import java.util.List;

public interface ShoppingCartService {

    //生成订单
    void createOrder(CreateOrderVo createOrderVo);

    //结算金额
    Double settlementAmount(List<SettlementAmountVO> settlementAmountVOList);

    //显示购物车内的书本信息
    List<ShowShoppingCartVO> showBookInfomation(List<List<String>> list);

    //显示订单中的书本信息
    List<BillBookVO> selectBillBookDetail(Integer billId);

    //支付订单
    void payForBill(Integer billId);

    List<Bill> selectByUserAndStatus(String status,Integer userId);
}
