package com.bookmarketsys.databasejob;

import com.bookmarketsys.databasejob.mapper.UserMapper;
import com.bookmarketsys.databasejob.pojo.User;
import com.bookmarketsys.databasejob.pojo.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabasejobApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo("unicorn");
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users.get(0).toString());
    }

}
