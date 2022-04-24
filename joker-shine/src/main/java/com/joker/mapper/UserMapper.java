package com.joker.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.bean.Order;
import com.joker.bean.User;
import com.joker.conf.DBConstants;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

/**
 * UserMapper
 *
 * @author joker
 * @version 1.0
 * 2022/1/5 15:49
 **/

@Repository
//@DS(DBConstants.DATASOURCE_USERS)//dynamic-datasource-spring-boot-starter，数据源名
public interface  UserMapper extends BaseMapper<User> {

    User selectById(@Param("id") Integer id);

    boolean insertUser(@Param("username")String username,@Param("password")String password);
}
