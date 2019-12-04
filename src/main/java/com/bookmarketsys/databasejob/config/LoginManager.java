package com.bookmarketsys.databasejob.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName LoginManager
 * @Description 登陆管理器
 * @Author 龚佳民
 * @Date 2019/11/29
 **/
@Component
public class LoginManager{

    //控制并发
    private static ConcurrentHashMap<String, HttpSession> sessionMap=new ConcurrentHashMap<>();



    public void addSession(String userName, HttpSession session){
        System.out.println(session.getId()+"登陆进来了");
        sessionMap.putIfAbsent(userName,session);
        System.out.println("map的大小："+sessionMap.size());
    }

    public HttpSession querySession(String userName){
        return sessionMap.get(userName);
    }

    public void updateSession(String userName,HttpSession newSession){
        HttpSession session = sessionMap.get(userName);
        System.out.println(newSession.getId()+" 挤掉了  "+session.getId());
        session.invalidate();
        sessionMap.put(userName,newSession);
    }

}
