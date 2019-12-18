package com.bookmarketsys.databasejob.controller;

import com.bookmarketsys.databasejob.mapper.UserMapper;
import com.bookmarketsys.databasejob.pojo.User;
import com.bookmarketsys.databasejob.service.SysAdminOprService;
import com.bookmarketsys.databasejob.util.Result;
import com.bookmarketsys.databasejob.util.ResultEnum;
import com.bookmarketsys.databasejob.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vanish
 * @date 2019/12/7 20:07
 */

@RestController
public class SysAdminController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SysAdminOprService sysAdminOprService;

    @RequestMapping("/deleteBillAdmin")
    Result deleteBillAdmin(@RequestBody User user){
        try {
            sysAdminOprService.deleteBillAdmin(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("订单管理员删除成功");
    }

    @RequestMapping("/deleteBookAdmin")
    Result deleteBookAdmin(@RequestBody User user){
        try {
            sysAdminOprService.deleteBookAdmin(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("图书管理员删除成功");
    }

    @RequestMapping("/updateBillAdmin")
    Result updateBillAdmin(@RequestBody User user){
        try {
            sysAdminOprService.updateBillAdmin(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("订单管理员更新成功");
    }

    @RequestMapping("/updateBookAdmin")
    Result updateBookAdmin(@RequestBody User user){
        try {
            sysAdminOprService.updateBookAdmin(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("图书管理员更新成功");
    }

    @RequestMapping("/insertBillAdmin")
    Result insertBillAdmin(@RequestBody User user){
        try {
            sysAdminOprService.insertBillAdmin(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("订单管理员添加成功");
    }

    @RequestMapping("/insertBookAdmin")
    Result insertBookAdmin(@RequestBody User user){
        try {
            sysAdminOprService.insertBookAdmin(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success("图书管理员添加成功");
    }
    @RequestMapping("/selectAllAdmin")
    Result selectAllAdmin(){
        List<User> users ;

        try {
           users= sysAdminOprService.selectAllAdmin();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"服务器开小差了");
        }
        return ResultUtil.success(users);
    }

    @RequestMapping("/selectByRoleId")
    public Result selectByRoleId(Integer roleId){
        List<User> userList = sysAdminOprService.selectByRoleId(roleId);
        return ResultUtil.success(userList);
    }

    @RequestMapping("/selectAdminLike")
    Result selectAdminLike(String userName) {
        List<User> users;

        try {
            users = sysAdminOprService.selectAdminLike(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(), "服务器开小差了");
        }
        return ResultUtil.success(users);
    }
    @RequestMapping("/updateAdmin")
    Result updateAdmin(@RequestBody User user){
        System.out.println(user.getId());
        sysAdminOprService.updateAdmin(user);
        return ResultUtil.success("管理员更新成功");
    }
}
