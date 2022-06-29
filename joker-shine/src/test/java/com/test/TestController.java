package com.test;

import com.joker.bean.User;
import com.joker.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test
 *
 * @author joker
 * @version 1.0
 * 2022/5/17 16:38
 **/

public class TestController extends JokerApplicationTests{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void  test1(){
        // 查询用户
        User user = userMapper.selectById(4);
        System.out.println(user);
    }

    @Test
    public void  test2(){
        System.out.println("!");
    }
}
