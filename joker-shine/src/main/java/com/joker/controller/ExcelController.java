package com.joker.controller;

import com.alibaba.fastjson.JSONArray;
import com.joker.bean.ExcelUser;
import com.joker.bean.ExcelUser1;
import com.joker.util.excel.ExcelExport;
import com.joker.util.excel.ExcelUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * ExcelController
 *
 * @author joker
 * @version 1.0
 * 2022/5/18 9:29
 **/

@RestController
public class ExcelController {


    public static void main(String[] args) {

    }

    @GetMapping("/test1")
    public String test1(){
        return "test";
    }

    /**
     * 导入解析为JSON
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/imporFile")
    public JSONArray imporUser(@RequestParam("file")MultipartFile file) throws Exception {
        JSONArray jsonArray = ExcelUtils.readMultipartFile(file);
        System.out.println("数据:"+jsonArray);
        return jsonArray;
    };


    /**
     * 导入解析为对象ExcelUser
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/imporFile1")
    public List<ExcelUser> imporUser1(@RequestParam("file")MultipartFile file) throws Exception {
        List<ExcelUser> excelUsers = ExcelUtils.readMultipartFile(file, ExcelUser.class);
        for (ExcelUser user : excelUsers) {
            System.out.println(user);
        }
        return excelUsers;
    };



    /**
     * 导入多个sheet页
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/imporFile2")
    public Map<String, JSONArray> imporUser2(@RequestParam("file")MultipartFile file) throws Exception {
        Map<String, JSONArray> sheet = ExcelUtils.readFileManySheet(file);
        sheet.forEach((k,v)->{
            System.out.println("sheet名称："+ k);
            System.out.println("sheet数据："+ v);
            System.out.println("--------");
        });
        return sheet;
    };


    /**
     * 导出
     * @param response
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response){
        List<Object> head = Arrays.asList("姓名", "性别", "职业", "口白", "属地",ExcelUtils.COLUMN_MERGE);
        ArrayList<Object> user1 = new ArrayList<>();
        user1.add("韩非子");
        user1.add("男");
        user1.add("法师");
        user1.add("这天下我要九十九");
        user1.add("韩");
        ArrayList<Object> user2 = new ArrayList<>();
        user2.add("东皇太一");
        user2.add("男");
        user2.add("法师");
        user2.add("悲莫悲兮生别离，乐莫乐兮新相知");
        user2.add("韩");
        // 将数据汇总
        List<List<Object>> sheetDataList = new ArrayList<>();
        sheetDataList.add(head);
        sheetDataList.add(user1);
        sheetDataList.add(user2);
        //设置下拉列表（键为第几列（从0开始），值为下拉数据）
        HashMap<Integer, List<String>> hashMap = new HashMap<>(1);
        hashMap.put(1,Arrays.asList("男","女"));

        ExcelUtils.export(response,"数据导出测试",sheetDataList,hashMap);
    }


    /**
     * 导出
     * @param response
     */
    @GetMapping("/export1")
    public void export1(HttpServletResponse response){
        ArrayList<ExcelUser1> arrayList = new ArrayList<>();
        ExcelUser1 user1 = new ExcelUser1();
        user1.setName("盖聂");
        user1.setAge(28);
        user1.setSex(1);
        user1.setCity("鬼谷");
        ExcelUser1 user2 = new ExcelUser1();
        user2.setName("卫庄");
        user2.setAge(26);
        user2.setSex(1);
        user2.setCity("鬼谷");
        arrayList.add(user1);
        arrayList.add(user2);
        //导出数据
        ExcelUtils.export(response,"用户表",arrayList,ExcelUser1.class);
    }



}
