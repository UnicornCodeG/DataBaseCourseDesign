package com.bookmarketsys.databasejob.serviceImpl;

import com.bookmarketsys.databasejob.service.LoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @ClassName LoginServiceImplTest
 * @Description
 * @Author 龚佳民
 * @Date 2019/11/28
 **/
@SpringBootTest
public class LoginServiceImplTest {
    @Autowired
    LoginService loginService;


    @Test
    public void test01(){


        Date date1 = new Date(System.currentTimeMillis()+5*60*1000);

        System.out.println(date1);

    }

}
