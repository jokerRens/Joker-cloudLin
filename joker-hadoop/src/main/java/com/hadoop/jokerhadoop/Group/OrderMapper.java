package com.hadoop.jokerhadoop.Group;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OrderMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {

    OrderBean orderBean = new OrderBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1.获取一行
        String line = value.toString();

        //2.切割
        String[] split = line.split(" ");

        //3.封装对象
        orderBean.setOrder_id(Integer.parseInt(split[0]));
        orderBean.setPrice(Double.parseDouble(split[2]));
        //4.写出
        context.write(orderBean,NullWritable.get());
    }
}
