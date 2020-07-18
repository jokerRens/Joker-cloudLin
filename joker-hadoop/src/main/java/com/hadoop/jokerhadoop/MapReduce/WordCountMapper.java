package com.hadoop.jokerhadoop.MapReduce;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * mapper阶段
 * KEYIN :   默认情况下，是mr框架所读到的一行文本的起始偏移量，Long;
 * VALUEIN： 默认情况下，是mr框架所读到的一行文本内容，String;此处用Text
 * KEYOUT：  是用户自定义逻辑处理完成之后输出数据中的key,在此处是单词，String；此处用Text
 * VALUEOUT：是用户自定义逻辑处理完成之后输出数据中的value，在此处是单词次数，Integer，此处用IntWritable
 */
public class WordCountMapper  extends Mapper<LongWritable, Text,Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1); //1

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //  joker joker
        System.out.println(key.toString());
        //1.获取一行
        String line = value.toString();

        //2.切割单词
        String[] words = line.split(" ");

        //3.循环写出
        for (String word : words) {
            k.set(word);
            context.write(k,v);
        }
    }
}
