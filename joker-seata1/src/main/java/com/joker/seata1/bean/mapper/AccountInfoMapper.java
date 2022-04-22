package com.joker.seata1.bean.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.joker.seata1.bean.domain.AccountInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【account_info】的数据库操作Mapper
* @createDate 2022-04-20 15:19:39
* @Entity com.joker.seata1.bean.domain.AccountInfo
*/
@DS("orders")
public interface AccountInfoMapper extends BaseMapper<AccountInfo> {

}




