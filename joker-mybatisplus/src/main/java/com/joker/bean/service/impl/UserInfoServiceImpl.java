package com.joker.bean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.bean.domain.UserInfo;
import com.joker.bean.service.UserInfoService;
import com.joker.bean.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2022-02-10 15:33:52
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




