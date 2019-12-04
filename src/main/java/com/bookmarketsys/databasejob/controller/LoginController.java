package com.bookmarketsys.databasejob.controller;

import com.bookmarketsys.databasejob.config.LoginManager;
import com.bookmarketsys.databasejob.pojo.User;
import com.bookmarketsys.databasejob.service.LoginService;
import com.bookmarketsys.databasejob.util.Result;
import com.bookmarketsys.databasejob.util.ResultEnum;
import com.bookmarketsys.databasejob.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName LoginController
 * @Description
 * @Author 龚佳民
 * @Date 2019/11/28
 **/
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    LoginManager loginManager;



    @RequestMapping("/register")
    Result register(@RequestBody User user){

        try {
            loginService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"信息填写错误");
        }

        return ResultUtil.success("注册成功");
    }
    @RequestMapping("/login")
    Result login(String userName, String password, HttpServletRequest request){
        /**
         * 1.输入用户名和密码,---->> 首先判断密码是否正确
         * 2.根据用户名查找当前session是否已经存在
         * 3.若不存在，则直接登陆，session中保存用户名
         * 4.若存在，则挤掉当前登陆的账号---->>>取出session，然后删除session，把新的session放入
         * 拦截请求的时候，去判断session中是否有userName，有则通过，没有就返回前端您已下线，请重新登陆
         **/
        List<User> users = loginService.login(userName, password);
        System.out.println(users);

        if (users.size()==0){
            return ResultUtil.error(ResultEnum.ERROR.getCode(),"用户名或密码错误");
        }
        //服务端的session存在生存时间，默认30分钟后自动销毁
        //所以被拦截的请求session中肯定是未经过处理的，里面没有任何数据
        //过期登陆和重复登陆，都会导致请求session和mapSession不一致

        HttpSession session = request.getSession();
        session.setAttribute("userName",userName);

        HttpSession mapSession = loginManager.querySession(userName);
        //1.map中没存当前用户的userName，直接add
        //2.在30分钟内，有新的session访问，update
        //3.30分钟后，mapsession！=null，id不相等，直接add
        //4.30分钟后，session重置
        if (mapSession==null || mapSession.getId()==session.getId()||session.isNew()){
            loginManager.addSession(userName,session);
        }else {
            loginManager.updateSession(userName,session);
        }

        return ResultUtil.success("登陆成功,返回roleId",users.get(0).getRoleId()) ;
    }
    @RequestMapping("/loginOut")
    public Result loginOut(String userName){

        return null;
    }
}
