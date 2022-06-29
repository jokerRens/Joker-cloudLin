package com.joker.seata2.controller;

import com.joker.seata1.controller.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.*;

/**
 * RestController
 *
 * @author joker
 * @version 1.0
 * 2022/4/25 11:36
 **/

@RestController
public class RestTestController {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
//        String ss = "aacabdkacaa";

        String s = longestPalindrome("ccc");
        System.out.println(s);
    }


    public static String longestPalindrome(String s) {
        String substring = "";
        for (int i = 0; i < s.length(); i++) {
            String s2 = s.substring(i, s.length());
            int indexOf = s2.indexOf(s.charAt(i), s2.indexOf(s.charAt(i)) + 1);
            if(indexOf==-1 && i==0){
                substring = s2.charAt(0)+"";
            }
            if(indexOf+i!=i){
                String s1 = s.substring(i, indexOf + 1 + i);
                if(s1.length()>substring.length()){
                    substring = s1;
                }
            }
        }
        return substring;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,nums,0,nums1.length);
        System.arraycopy(nums2,0,nums,nums1.length,nums2.length);
        Arrays.sort(nums);
        if(nums.length%2==0){
            double a = (float)(nums[(nums.length / 2) - 1] + nums[(nums.length / 2)]) / 2;
            return a;
        }else {
            return nums[nums.length/2];
        }
    }


    public static String longestCommonPrefix(String[] strs) {
        String temp = "";
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; i < str.length(); i++) {
                char charAt = str.charAt(j);

            }
        }
        return temp;
    }

    public static int[] twoSum(int[] nums, int target) {
        int size = 2;
        int[] ints = new int[size];
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 1; i1 < nums.length; i1++) {
                if(nums[i]+nums[i1]==target && i1>i){
                    ints[0] = i;
                    ints[1] = i1;
                    return ints;
                }
            }
        }
        return null;
    }


    @GetMapping("/test1")
    public String test1(){
        return "成功";
    }


    @RequestMapping("/gethello")
    public String getHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:5008/test2", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }

    @RequestMapping("/getname")
    public String getName(){
        ResponseEntity<String> joker = restTemplate.getForEntity("http://127.0.0.1:5008/test3?name={1}", String.class, "joker");
        String body = joker.getBody();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>");
        return result.toString();
    }

    @RequestMapping("/getname2")
    public String getName2(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","joker2");
        map.put("title","ceshi");
        ResponseEntity<String> joker = restTemplate.getForEntity("http://127.0.0.1:5008/test4?name={name}&title={title}", String.class, map);
        String body = joker.getBody();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>");
        return result.toString();
    }


    @RequestMapping("/getbook")
    public String getBook(){
        ResponseEntity<Book> entity = restTemplate.getForEntity("http://127.0.0.1:5008/test5", com.joker.seata1.controller.Book.class);
        Book body = entity.getBody();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>");
        return result.toString();
    }


    @RequestMapping("/getname3")
    public String getName3(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","joker2");
        map.put("title","ceshi");
        String body = restTemplate.getForObject("http://127.0.0.1:5008/test4?name={name}&title={title}", String.class, map);
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>");
        return result.toString();
    }


    /**
     * POST
     */

    @RequestMapping("/getbook2")
    public String getBook2(){
        com.joker.seata1.controller.Book book = new com.joker.seata1.controller.Book();
        book.setName("哪里都是你");
        com.joker.seata1.controller.Book body = restTemplate.postForObject("http://127.0.0.1:5008/test6", book, com.joker.seata1.controller.Book.class);
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>");
        return result.toString();
    }





}
