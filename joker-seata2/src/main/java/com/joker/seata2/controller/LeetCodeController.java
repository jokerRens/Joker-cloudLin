package com.joker.seata2.controller;

import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.regex.Pattern;


/**
 * LeetCodeController
 *
 * @author joker
 * @version 1.0
 * 2022/5/7 10:18
 **/

public class LeetCodeController {

    public static void main(String[] args) {
        int [] a= {2,2,1,1,1,2,2};
        int i = majorityElement(a);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        int min = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            long count = Arrays.stream(nums).filter(s -> s == nums[finalI]).count();
            if(count>min){
                return  nums[i];
            }
        }
        return 0;
    }

    public static String convertToTitle(int columnNumber) {
        String a = "";
        while (columnNumber>0){
            columnNumber--;
             a += ((char)columnNumber%26 + 'A');
            System.out.println(a);
        }
        return a;
    }

    public static int singleNumber(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <len ; i++) {
            arrayList.add(nums[i]);
        }
        int temp = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            temp = arrayList.get(i);
            arrayList.remove(i);
            if(!arrayList.contains(temp)){
                return temp;
            }else {
                arrayList.add(i,temp);
            }
        }
        return 0;
    }

    public static int[] plusOne(int[] digits) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digits.length; i++) {
            stringBuffer.append(digits[i]);
        }
        String str = stringBuffer.toString();
        Long value = Long.valueOf(str);
        value = value + 1;
        String string = value.toString();

        int[] arr = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            arr[i] = Integer.valueOf(string.substring(i, i + 1));
        }
        return arr;
    }


    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        System.out.println(Arrays.toString(split));
        String s1 = split[split.length - 1];
        return s1.length();
    }

    public static String multiply(String num1, String num2) {
        Double value1 = Double.valueOf(num1);
        Double value2 = Double.valueOf(num2);
        Double num = value1 * value2;
        return num.toString();
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        boolean temp = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (!temp) {
                    arr[0] = i;
                    arr[1] = i;
                    temp = true;
                } else {
                    arr[1] = i;
                }
            }
        }
        return arr;
    }


    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            ;
        }
        return -1;
    }


    public static void nextPermutation(int[] nums) {
        boolean temp = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            if (a > b && !temp) {
                nums[i] = b;
                nums[i - 1] = a;
                temp = true;
                break;
            }
        }
        if (!temp) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(i);
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public static int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer : list) {
            if (!arrayList.contains(integer)) {
                arrayList.add(integer);
            }
        }
        nums = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            nums[i] = arrayList.get(i);
        }
        System.out.println(Arrays.toString(nums));
        return nums.length;
    }


    public static int divide(int dividend, int divisor) {
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int num = dividend / divisor;
        if (dividend < 0 && divisor < 0) {
            num = Math.abs(num);
        }
        return num;
    }

    public static int strStr(String haystack, String needle) {
        int indexOf = haystack.indexOf(needle);
        return indexOf;
    }

    public static int searchInsert(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            list.add(num);
        }
        if (list.contains(target)) {
            return list.indexOf(target);
        } else {
            list.add(target);
            Collections.sort(list);
            return list.indexOf(target);
        }
    }

    public static int removeElement(int[] nums, int val) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            list.add(num);
        }
        list.removeIf(s ->
                s.equals(val)
        );
        nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        System.out.println(Arrays.toString(nums));
        return nums.length;
    }


    public static int myAtoi(String s) {
        String trim = s.trim();
        String trim1 = Pattern.compile("[^0-9]").matcher(trim).replaceAll("").trim();
        return Integer.valueOf(trim1);
    }


    public static int reverse(int x) {
        String str = x + "";
        boolean contains = str.contains("-");
        if (contains) {
            str = str.substring(1, str.length());
        }
        String s = new StringBuffer(str).reverse().toString();
        Double value = Double.parseDouble(s);
        if (value > Integer.MAX_VALUE) {
            return 0;
        }
        if (contains) {
            s = "-" + s;
        }
        return Integer.valueOf(s);
    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String str = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String s1 = s.substring(i, j + 1);
                    int len1 = s1.length();
                    int n = len1 / 2;
                    int star;
                    int end;
                    if (len1 % 2 != 0) {
                        star = n - 1;
                        end = n + 1;
                    } else {
                        star = n - 1;
                        end = n;
                    }
                    boolean temp = false;
                    while (true) {
                        if (s1.charAt(star) == s1.charAt(end)) {
                            if (star == 0 || end == s1.length() - 1) {
                                temp = true;
                                break;
                            }
                            star--;
                            end++;
                        } else {
                            break;
                        }
                    }
                    if (temp) {
                        if (s1.length() > str.length()) {
                            str = s1;
                        }
                    }
                }
            }
        }
        return str;
    }


    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String str = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int r = j;
                int l = i;
                while (l < r) {
                    if (s.charAt(l) == s.charAt(r)) {
                        String s1 = s.substring(l, r + 1);
                        if (s1.length() > str.length()) {
                            str = s1;
                        }
                        l--;
                        r++;
                    }
                    break;
                }
            }
        }
        return str;
    }
}
