package com.hadoop.jokerhadoop.Writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    Text k = new Text();
    FlowBean v = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // 7 18040480198 192.168.200.15 1116  954  200

        //1.获取一行
        String line = value.toString();

        //2.切割\t
        String[] split = line.split("   ");

        //3.封装对象
        k.set(split[1]); //封装手机号
        long upFlow = Long.parseLong(split[split.length - 3]);
        long downFlow = Long.parseLong(split[split.length - 2]);

        v.setUpFlow(upFlow);
        v.setDownFlow(downFlow);
        v.setSumFlow(upFlow+downFlow);

        //4.写出
        context.write(k,v);
    }
}
