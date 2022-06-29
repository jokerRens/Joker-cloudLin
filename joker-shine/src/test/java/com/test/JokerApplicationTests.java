package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * JokerApplicationTests
 *
 * @author joker
 * @version 1.0
 * 2022/5/17 16:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
@MapperScan(basePackages = "com.joker.mapper")//扫描mapper接口
public class JokerApplicationTests {

    @Before
    public void init(){
        System.out.println("开始测试...");
    }

    @After
    public void after(){
        System.out.println("测试结束...");
    }
}
