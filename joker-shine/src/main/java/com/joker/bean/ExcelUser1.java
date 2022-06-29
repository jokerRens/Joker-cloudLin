package com.joker.bean;

import com.joker.util.excel.ExcelExport;
import lombok.Data;

/**
 * ExcelUser1
 *
 * @author joker
 * @version 1.0
 * 2022/5/18 16:16
 **/
@Data
public class ExcelUser1 {

    @ExcelExport(value = "姓名")
    private String name;

    @ExcelExport(value = "年龄")
    private Integer age;

    @ExcelExport(value = "性别")
    private Integer sex;

    @ExcelExport(value = "城市")
    private String city;
}
