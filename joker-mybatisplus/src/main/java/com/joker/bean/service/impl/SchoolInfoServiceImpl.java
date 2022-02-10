package com.joker.bean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.bean.domain.SchoolInfo;
import com.joker.bean.service.SchoolInfoService;
import com.joker.bean.mapper.SchoolInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【school_info】的数据库操作Service实现
* @createDate 2022-02-10 16:02:28
*/
@Service
public class SchoolInfoServiceImpl extends ServiceImpl<SchoolInfoMapper, SchoolInfo>
    implements SchoolInfoService{

}




