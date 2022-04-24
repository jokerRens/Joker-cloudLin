package com.joker.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.bean.Order;
import com.joker.conf.DBConstants;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

/**
 * OrderMapper
 *
 * @author joker
 * @version 1.0
 * 2022/1/5 15:49
 **/

@Repository
//@DS(DBConstants.DATASOURCE_ORDERS)
public interface  OrderMapper extends BaseMapper<Order> {

    Order selectById(@Param("id") Integer id);

    boolean insertOrder(@Param("userId")Integer userId);
}
