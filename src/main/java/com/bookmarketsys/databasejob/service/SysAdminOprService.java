package com.bookmarketsys.databasejob.service;


import com.bookmarketsys.databasejob.pojo.User;

import java.util.List;

/**
 *  methods for system administrator to operate
 *
 *  2019-12-5 chenliang
 *
 */
public interface SysAdminOprService {

    User deleteBillAdmin(int id);      //删除订单管理员
    User deleteBookAdmin(int id);      //删除图书管理员
    User updateBillAdmin(User billAdmin);      //更新订单管理员
    User updateBookAdmin(User bookAdmin);      //更新图书管理员
    User insertBookAdmin(User bookAdmin);      //插入图书管理员
    User insertBillAdmin(User billAdmin);      //插入订单管理员
    List<User> selectAllAdmin();






}