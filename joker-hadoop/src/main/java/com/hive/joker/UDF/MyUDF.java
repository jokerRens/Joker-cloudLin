package com.hive.joker.UDF;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyUDF extends UDF {


    public static void main(String[] args) {

    }

    public  int evaluate(int data){
        return data+5;
    }
}
