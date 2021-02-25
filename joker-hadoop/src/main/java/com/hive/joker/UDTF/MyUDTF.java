package com.hive.joker.UDTF;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.*;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;
import java.util.List;

public class MyUDTF extends GenericUDTF {

    private List<String> dataList = new ArrayList<>();


    //定义输出数据的列名和数据类型
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
//        return super.initialize(argOIs);

        //定义输出数据的列名
        ArrayList<String> fieldNames = new ArrayList<>();//字段名
        fieldNames.add("word");

        //定义输出数据的类型
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<>();//列名称
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames,fieldOIs);
    }

    @Override
    public void process(Object[] args) throws HiveException {

        //1.获取数据、
        String data = args[0].toString();

        //2.获取分隔符
        String splitKey = args[1].toString();

        //3.切分数据
        String[] words = data.split(splitKey);

        //4.遍历写出
        for (String word : words) {
            //5.将数据放置集合
            dataList.clear();
            dataList.add(word);

            //6.写出数据操作
            forward(dataList);
        }

    }

    @Override
    public void close() throws HiveException {

    }


    public static void main(String[] args) {

    }
}
