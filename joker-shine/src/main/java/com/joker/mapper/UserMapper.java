package com.joker.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.joker.bean.User;
import com.joker.conf.DBConstants;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 *
 * @author joker
 * @version 1.0
 * 2022/1/5 15:49
 **/

@Repository
@DS(DBConstants.DATASOURCE_USERS)//dynamic-datasource-spring-boot-starter，数据源名
public interface  UserMapper {

    User selectById(@Param("id") Integer id);
}
