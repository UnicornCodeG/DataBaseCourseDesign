package com.bookmarketsys.databasejob.service;

import com.bookmarketsys.databasejob.pojo.User;

import java.util.List;

/**
 * @ClassName Login
 * @Description
 * @Author 龚佳民
 * @Date 2019/11/27
 **/
public interface LoginService {
    //注册
    void register(User user);
    //登陆
    List<User> login(String name, String passWord);
}
