package com.hadoop.jokerhadoop.MapReduce;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * mapper阶段
 * KEYIN :   入参key
 * VALUEIN： 入参value类型
 * KEYOUT：  出参key
 * VALUEOUT：出参value类型
 */
public class WordCountMapper  extends Mapper<LongWritable, Text,Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1); //1

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //  joker joker

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
