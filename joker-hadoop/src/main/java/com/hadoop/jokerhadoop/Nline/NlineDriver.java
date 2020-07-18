package com.hadoop.jokerhadoop.Nline;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class NlineDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"D:\\Joker\\inputDemo2","D:\\Joker\\Out6"};

        Configuration conf = new Configuration();

        //1.获取job对象
        Job job = Job.getInstance(conf);
        NLineInputFormat.setNumLinesPerSplit(job,3); //设置每个InpuitSplit划分3条记录
        job.setInputFormatClass(NLineInputFormat.class);

        //2.设置jar储存路径
        job.setJarByClass(NlineDriver.class);

        //3.关联mapper和reduce类
        job.setMapperClass(NlineMapper.class);
        job.setReducerClass(NlineReduce.class);

        //4.设置mapper输出的key和value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //5.设置最终输出的key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setInputFormatClass(KeyValueTextInputFormat.class);

        //6.设置输出路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //7.提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0:1);


    }

}
