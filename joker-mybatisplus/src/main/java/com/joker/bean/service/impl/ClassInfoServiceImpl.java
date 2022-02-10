package com.joker.bean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.bean.domain.ClassInfo;
import com.joker.bean.service.ClassInfoService;
import com.joker.bean.mapper.ClassInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【class_info】的数据库操作Service实现
* @createDate 2022-02-10 16:02:28
*/
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo>
    implements ClassInfoService{

}




