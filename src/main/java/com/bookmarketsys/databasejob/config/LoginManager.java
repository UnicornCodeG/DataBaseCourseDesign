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


    //控制并发,userName--session
    private static ConcurrentHashMap<String, HttpSession> sessionMap=new ConcurrentHashMap<>();

    public void addSession(String userName, HttpSession session){
        System.out.println(session.getId()+"登陆进来了");
        sessionMap.putIfAbsent(userName,session);
    }

    public HttpSession querySession(String userName){
        return sessionMap.get(userName);
    }

    public void updateSession(String userName,HttpSession newSession){
        HttpSession session = sessionMap.get(userName);
        //session活跃超时，自动销毁，执行报错
        try {
            session.invalidate();
            System.out.println(newSession.getId()+" 挤掉了  "+session.getId());
        } catch (Exception e) {
            addSession(userName,newSession);
            return;
        }
        sessionMap.put(userName,newSession);
    }

    public void deleteSession(String userName){
        sessionMap.remove(userName);
        HttpSession session = sessionMap.get(userName);
        session.invalidate();
    }

    //活跃的session数
    public Integer getMapSize(){
        return sessionMap.size();
    }
}
