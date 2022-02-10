package com.joker.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.joker.bean.domain.ClassInfo;
import com.joker.bean.domain.SchoolInfo;
import com.joker.bean.domain.StudentInfo;
import com.joker.bean.domain.UserInfo;
import com.joker.bean.dto.StudentInfoDto;
import com.joker.bean.mapper.StudentInfoMapper;
import com.joker.bean.service.StudentInfoService;
import com.joker.bean.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserInfoController
 *
 * @author joker
 * @version 1.0
 * 2022/2/10 15:39
 **/
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StudentInfoMapper studentInfoMapper;



    @GetMapping("/demo")
    public void demo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUserName("keke");
        userInfo.setAge(3);
        userInfo.setSource(1);
        boolean save = userInfoService.save(userInfo);
    }


    /**
     * 联表查询单个
     */
    @GetMapping("/demo1")
    public void selectJoinOne() {
        StudentInfoDto studentInfoDTO = studentInfoMapper.selectJoinOne(StudentInfoDto.class,
            new MPJLambdaWrapper<StudentInfo>()
                    .selectAll(StudentInfo.class)
                    .select(SchoolInfo::getSchoolName)
                    .selectAs(SchoolInfo::getSchoolAddr, StudentInfoDto::getScAddr)
                    .select(ClassInfo::getClassName)
                    .leftJoin(SchoolInfo.class, SchoolInfo::getId, StudentInfo::getSchoolId)
                    .leftJoin(ClassInfo.class, ClassInfo::getId, StudentInfo::getClassId)
                    .eq(StudentInfo::getId, 1));
        System.out.println(studentInfoDTO.toString());
    }

    /**
     * 联表查询多个
     */
    @GetMapping("/demo2")
    public void selectJoinList() {
        List<StudentInfoDto> studentInfoDTO = studentInfoMapper.selectJoinList(StudentInfoDto.class,
                new MPJLambdaWrapper<StudentInfo>()
                        .selectAll(StudentInfo.class)
                        .select(SchoolInfo::getSchoolName)
                        .selectAs(SchoolInfo::getSchoolAddr, StudentInfoDto::getScAddr)
                        .select(ClassInfo::getClassName)
                        .leftJoin(SchoolInfo.class, SchoolInfo::getId, StudentInfo::getSchoolId)
                        .leftJoin(ClassInfo.class, ClassInfo::getId, StudentInfo::getClassId)
                        );
        System.out.println(studentInfoDTO.toString());
    }


    /**
     * 联表查询分页
     */
    @GetMapping("/demo3")
    public void selectJoinPage() {
        IPage<StudentInfoDto> studentInfoDTO = studentInfoMapper.selectJoinPage(new Page<StudentInfo>(1, 2),StudentInfoDto.class,
                new MPJLambdaWrapper<StudentInfo>()
                        .selectAll(StudentInfo.class)
                        .select(SchoolInfo::getSchoolName)
                        .selectAs(SchoolInfo::getSchoolAddr, StudentInfoDto::getScAddr)
                        .select(ClassInfo::getClassName)
                        .leftJoin(SchoolInfo.class, SchoolInfo::getId, StudentInfo::getSchoolId)
                        .leftJoin(ClassInfo.class, ClassInfo::getId, StudentInfo::getClassId)
                        .orderByAsc(StudentInfo::getId)
        );
        System.out.println(studentInfoDTO.getCurrent());
        System.out.println(studentInfoDTO.getTotal());
        System.out.println(studentInfoDTO.getPages());
        System.out.println(studentInfoDTO.getSize());
        List<StudentInfoDto> records = studentInfoDTO.getRecords();
        System.out.println(records.toString());
    }


}
