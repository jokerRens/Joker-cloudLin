package com.joker.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * TestCreateTable
 *
 * @author joker
 * @version 1.0
 * 2022/5/18 10:59
 **/

public class TestCreateTable {

    public static void main(String[] args) {
        testCreateDbTable();
    }

    public static void testCreateDbTable(){
        //默认创建方式
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //通用的创建方式，指定配置文件名和Bean名称
//        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml", "processEngineConfiguration");
//        ProcessEngine processEngine1 = processEngineConfiguration.buildProcessEngine();
        System.out.println(processEngine);
    }
}
