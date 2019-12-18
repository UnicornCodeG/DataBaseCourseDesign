package com.bookmarketsys.databasejob.service.serviceImpl;

import com.bookmarketsys.databasejob.mapper.MenuMapper;
import com.bookmarketsys.databasejob.mapper.UserMapper;
import com.bookmarketsys.databasejob.pojo.User;
import com.bookmarketsys.databasejob.pojo.UserExample;
import com.bookmarketsys.databasejob.service.SysAdminOprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vanish
 * @date 2019/12/5 14:14
 * 对图书管理员和订单管理员的CRUD操作，返回值均为 User
 */
@Service
public class SysAdminOprServiceImpl implements SysAdminOprService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    MenuMapper menuMapper;
    @Override
    public User deleteBillAdmin(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user ==null) {
            return null;
        }else {
            int i = userMapper.deleteByPrimaryKey(id);
            return user;
        }


    }

    @Override
    public User deleteBookAdmin(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user ==null) {
            return null;
        }else {
            int i = userMapper.deleteByPrimaryKey(id);
            return user;
        }
    }

    @Override
    public User updateBillAdmin(User billAdmin) {
        int i = userMapper.updateByPrimaryKey(billAdmin);
        if (i == 0){
            return null;
        }else {
            return billAdmin;
        }
    }

    @Override
    public User updateBookAdmin(User bookAdmin) {
        int i = userMapper.updateByPrimaryKey(bookAdmin);
        if (i == 0){
            return null;
        }else {
            return bookAdmin;
        }
    }



    @Override
    public User insertBillAdmin(User billAdmin) {
        int i = userMapper.insert(billAdmin);
        if (i == 0){
            return null;
        }else {
            return billAdmin;
        }
    }

    @Override
    public List<User> selectAllAdmin() {
        UserExample userExample=new UserExample();
        userExample.createCriteria().getAllCriteria();
        List<User> users=userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public List<User> selectByRoleId(Integer roleId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andRoleIdEqualTo(roleId);
        List<User> userList = userMapper.selectByExample(userExample);
        for (User user : userList) {
            String menuName = menuMapper.selectByPrimaryKey(user.getRoleId()).getMenuName();
            user.setMenuName(menuName);
        }
        return userList;
    }


    @Override
    public User insertBookAdmin(User bookAdmin) {
        int i = userMapper.insert(bookAdmin);
        if (i == 0){
            return null;
        }else {
            return bookAdmin;
        }
    }
    @Override
    public List<User> selectAdminLike(String username) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNameLike(username);
        List<User> users=userMapper.selectByExample(userExample);
        for (User user : users) {
            String menuName = menuMapper.selectByPrimaryKey(user.getRoleId()).getMenuName();
            user.setMenuName(menuName);
        }
        return  users;

    }
}
