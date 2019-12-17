package com.bookmarketsys.databasejob.controller;

import com.bookmarketsys.databasejob.mapper.BillBookMapper;
import com.bookmarketsys.databasejob.mapper.BillMapper;
import com.bookmarketsys.databasejob.pojo.Bill;
import com.bookmarketsys.databasejob.service.BillAdminOprService;
import com.bookmarketsys.databasejob.util.Result;
import com.bookmarketsys.databasejob.util.ResultEnum;
import com.bookmarketsys.databasejob.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vanish
 * @date 2019/12/7 19:49
 */

@RestController
public class BillAdminController {
    @Autowired
    BillMapper billMapper;
    @Autowired
    BillBookMapper billBookMapper;
 //   @Autowired
 //   BillProcessMapper billProcessMapper;
    @Autowired
    BillAdminOprService billAdminOprService;

    @PostMapping("/selectBill")
    Result selectBill(@RequestBody Bill bill){
        Bill bill1 = new Bill();
        try {
            System.out.println(bill);
            bill1 = billAdminOprService.selectBill(bill.getId());
        } catch (Exception e) {
            System.out.println(bill1+"?");
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success(bill1);
    }



    @RequestMapping("/deleteBill")
    Result deleteBill(@RequestBody Bill bill){
        try {
            billAdminOprService.deleteBill(bill.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("订单删除成功!");
    }

    @RequestMapping("/updateBill")
    Result updateBill(@RequestBody Bill bill){
        try {
            billAdminOprService.updateBill(bill);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("订单更新成功!");
    }

    @RequestMapping("/addBill")
    Result addBill(@RequestBody Bill bill){
        try {
            billAdminOprService.addBill(bill);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("订单添加成功!");
    }

    @RequestMapping("/selectAllBill")
    Result selectAllBill(){
        List<Bill> bills ;

        try {
              bills=billAdminOprService.selectAllBill();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success(bills);

    }

}
