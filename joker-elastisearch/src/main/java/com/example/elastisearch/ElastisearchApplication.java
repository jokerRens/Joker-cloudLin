package com.example.elastisearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * spring boot  默认支持两种技术和ES交互
 *1.jest
 *      默认不生效 需要导入jest包
 *2.spring data elasticsearch
 *      1.client 节点信息 clusterNodes; clusterName
 *      2.ElasticsearchTemplate
 *      3.ElasticsearchRepository
 */
@SpringBootApplication
public class ElastisearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElastisearchApplication.class, args);
    }

    @GetMapping("/haha")
    public void demo(){
        System.out.println("来了");
    }

}
