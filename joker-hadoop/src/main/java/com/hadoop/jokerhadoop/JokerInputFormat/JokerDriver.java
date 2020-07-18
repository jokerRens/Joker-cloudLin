package com.hadoop.jokerhadoop.JokerInputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

import java.io.IOException;

public class JokerDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"D:\\Joker\\inputDemo3","D:\\Joker\\Out7"};

        Configuration conf = new Configuration();
        //1.获取job对象
        Job job = Job.getInstance(conf);

        //2.设置jar储存路径
        job.setJarByClass(JokerDriver.class);

        //3.关联mapper和reduce类
        job.setMapperClass(JokerMapper.class);
        job.setReducerClass(JokerReduce.class);

        //4.设置mapper输出的key和value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(BytesWritable.class);

        //5.设置最终输出的key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(BytesWritable.class);

        //设置输入的InputFormat
        job.setInputFormatClass(JokerInputFormat.class);
        //设置输出的OutputFormat
        job.setOutputFormatClass(SequenceFileOutputFormat.class);


        //6.设置输出路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //7.提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0:1);
    }

}
