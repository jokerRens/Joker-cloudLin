package com.joker.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * Generator
 *
 * @author joker
 * @version 1.0
 * 2022/3/16 15:54
 **/

public class Generator {

    public static void main(String[] args) {
//        String projectPath = System.getProperty("user.dir");
        String projectPath = "D:\\DALIANS\\Joker-cloudLin\\joker-mybatisplus";
        System.out.println(projectPath + "\\src\\main\\java");
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/joker?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&useSSL=false", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("joker") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath+"\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.joker") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath+"\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("class_info") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")
                    .mapperBuilder().enableMapperAnnotation()

                    ; // 设置过滤表前缀
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.ENTITY)
//                            .entity("/templates/entity.java")
//                            .service("/templates/service.java")
//                            .serviceImpl("/templates/serviceImpl.java")
//                            .mapper("D:\\DALIANS\\Joker-cloudLin\\joker-mybatisplus\\src\\main\\resources\\template\\mapper.java")
                              .mapper("/template/mapper2.java")
//                            .xml("/templates/mapper.xml")
//                            .controller("/templates/controller.java")
                            .build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
