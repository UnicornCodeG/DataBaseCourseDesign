package com.bookmarketsys.databasejob.service.serviceImpl;

import com.bookmarketsys.databasejob.mapper.BillMapper;
import com.bookmarketsys.databasejob.mapper.UserMapper;
import com.bookmarketsys.databasejob.pojo.Bill;
import com.bookmarketsys.databasejob.pojo.BillExample;
import com.bookmarketsys.databasejob.pojo.User;
import com.bookmarketsys.databasejob.pojo.UserExample;
import com.bookmarketsys.databasejob.service.BillAdminOprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vanish
 * @date 2019/12/7 18:39
 * 以下操作失败，都返回null
 */
@Service
public class BillAdminOprServiceImpl implements BillAdminOprService {

  @Autowired
  BillMapper billMapper;
  @Autowired
  UserMapper userMapper;

    @Override
     public Bill selectBill(int bill_id) {


        System.out.println("billMapper");
        System.out.println(billMapper);
        System.out.println("billMapper done");


        Bill bill = billMapper.selectByPrimaryKey(bill_id);

        if (bill == null){

            return null;
        }else {
            return bill;
        }
    }

    @Override
    public Bill deleteBill(int bill_id) {
        Bill bill = billMapper.selectByPrimaryKey(bill_id);
        if (bill == null){
            return null;
        }else {
            int i = billMapper.deleteByPrimaryKey(bill_id);
            return bill;
        }
    }

    @Override
    public Bill updateBill(Bill bill) {
        int i = billMapper.updateByPrimaryKey(bill);
        if (i == 0){
            return null;
        }else {
            return bill;
        }

    }

    @Override
    public Bill addBill(Bill bill) {
        int i = billMapper.insert(bill);
        if (i == 0){
            return null;
        }else {
            return bill;
        }
    }

    @Override
    public List<Bill> selectAllBill() {
        BillExample billExample=new BillExample();
        billExample.createCriteria().getAllCriteria();
        List<Bill> bills=billMapper.selectByExample(billExample);
        return  bills;

    }

    @Override
    public List<Bill> selectByStatus(String status) {
        BillExample billExample = new BillExample();
        billExample.createCriteria().andStatusEqualTo(status);
        List<Bill> bills = billMapper.selectByExample(billExample);
        return bills;
    }
    @Override
    public List<Bill> selectBillLike(String username) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNameLike(username);
        List<User> users=userMapper.selectByExample(userExample);
        List<Integer> userIds=new ArrayList<>();
        for(User user:users) {
            userIds.add(user.getId());
        }
        BillExample billExample=new BillExample();
        billExample.createCriteria().andUserIdIn(userIds);
        return  billMapper.selectByExample(billExample);
    }
}
