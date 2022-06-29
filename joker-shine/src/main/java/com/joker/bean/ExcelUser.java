package com.joker.bean;

import com.joker.util.excel.ExcelImport;
import lombok.Data;

/**
 * ExcelUser
 *
 * @author joker
 * @version 1.0
 * 2022/5/18 14:59
 **/
@Data
public class ExcelUser {

    /** 表格行号 */
    private int rowNum;

    @ExcelImport(value = "姓名", required = true)
    private String name;

    @ExcelImport("年龄")
    private Integer age;

    @ExcelImport(value = "性别", kv = "1-男;2-女")
    private Integer sex;

    @ExcelImport(value = "电话", maxLength = 11, required = true)
    private String tel;

    @ExcelImport("城市")
    private String city;

    @ExcelImport("头像")
    private String avatar;

    /** 错误提示 */
    private String rowTips;

    /** 原始数据 */
    private String rowData;
}
