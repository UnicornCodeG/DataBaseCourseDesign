package com.bookmarketsys.databasejob.service.serviceImpl;

import com.bookmarketsys.databasejob.mapper.UserMapper;
import com.bookmarketsys.databasejob.pojo.User;
import com.bookmarketsys.databasejob.pojo.UserExample;
import com.bookmarketsys.databasejob.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName LoginImpl
 * @Description
 * @Author 龚佳民
 * @Date 2019/11/27
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void register(User user) {
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public List<User> login(String name, String passWord) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(name).andPasswordEqualTo(passWord);
        List<User> users = userMapper.selectByExample(userExample);

        return users;
    }

}
