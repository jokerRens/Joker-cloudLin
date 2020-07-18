package com.hadoop.jokerhadoop.Nline;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class NlineMapper extends Mapper<Text, Text, Text, IntWritable> {


    Text k = new Text();
    IntWritable v = new IntWritable(1);
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {

        //1.获取一行
        String line = value.toString();

        //2.切割
        String[] split = line.split("");

        //3.循环
        for (String s:split){

         k.set(s);
         context.write(k,v);
        }
    }
}
