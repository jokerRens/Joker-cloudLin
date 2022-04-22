package com.joker.seata1.bean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.seata1.bean.domain.AccountInfo;
import com.joker.seata1.bean.service.AccountInfoService;
import com.joker.seata1.bean.mapper.AccountInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【account_info】的数据库操作Service实现
* @createDate 2022-04-20 15:19:39
*/
@Service
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfo>
    implements AccountInfoService{

}




