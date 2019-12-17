package com.bookmarketsys.databasejob.service;

import com.bookmarketsys.databasejob.pojo.Bill;

import java.util.List;

/**
 * methods for Bill  Administrator to operate
 *
 * 2019-12-5 chenliang
 */
public interface BillAdminOprService {

   //以下操作失败，都返回null
    Bill selectBill(int bill_id);
    Bill deleteBill(int bill_id);
    Bill updateBill(Bill bill);
    Bill addBill(Bill bill);
    List<Bill> selectAllBill();


}
