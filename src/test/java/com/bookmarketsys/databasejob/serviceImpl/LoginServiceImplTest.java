package com.bookmarketsys.databasejob.serviceImpl;

import com.bookmarketsys.databasejob.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName LoginServiceImplTest
 * @Description
 * @Author 龚佳民
 * @Date 2019/11/28
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceImplTest {
    @Autowired
    LoginService loginService;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test01(){
        loginService.login("unicorn","123456");
    }

    @Test
    public void test02(){
        String shoppingCartUserMenuKey="shoppingCart:1:1";
        String shoppingCartUserKey="shoppingCart:1";
        ListOperations listOperations = redisTemplate.opsForList();
        List range = listOperations.range(shoppingCartUserKey, 0, -1);
        List range1 = listOperations.range(shoppingCartUserMenuKey, 0, -1);
        System.out.println(range);
        System.out.println(range1);
        /*  listOperations.remove(shoppingCartUserKey,1,new ArrayList<>());
        System.out.println(listOperations.range(shoppingCartUserKey, 0, -1));*/
    }
}
