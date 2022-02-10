package com.joker.bean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.bean.domain.StudentInfo;
import com.joker.bean.service.StudentInfoService;
import com.joker.bean.mapper.StudentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【student_info】的数据库操作Service实现
* @createDate 2022-02-10 16:02:28
*/
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo>
    implements StudentInfoService{

}




