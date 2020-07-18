package com.hadoop.jokerhadoop.Table;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class TableMapper extends Mapper<LongWritable, Text, Text, TableBean> {

    String name;
    TableBean bean = new TableBean();
    Text k = new Text();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {

        //获取文件名称
        FileSplit split = (FileSplit)context.getInputSplit();
        name = split.getPath().getName();

    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1.获取一行
        String line = value.toString();
        if(name.startsWith("order")){//订单表
            String[] split = line.split("  ");
            //封装key和value
            bean.setId(split[0]);
            bean.setPid(split[1]);
            bean.setAmount(Integer.parseInt(split[2]));
            bean.setPname("");
            bean.setFlag("order");

            k.set(split[1]);

        }else{//产品表
            String[] split = line.split("  ");
            //封装key和value
            bean.setId("");
            bean.setPid(split[0]);
            bean.setAmount(0);
            bean.setPname(split[1]);
            bean.setFlag("pd");

            k.set(split[0]);
        }
    }
}
