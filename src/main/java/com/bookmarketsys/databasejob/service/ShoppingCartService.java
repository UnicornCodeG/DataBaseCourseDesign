package com.bookmarketsys.databasejob.service;

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
}
