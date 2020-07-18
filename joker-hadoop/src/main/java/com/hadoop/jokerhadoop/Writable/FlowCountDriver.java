package com.hadoop.jokerhadoop.Writable;

import com.hadoop.jokerhadoop.MapReduce.WordCountDriver;
import com.hadoop.jokerhadoop.MapReduce.WordCountMapper;
import com.hadoop.jokerhadoop.MapReduce.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowCountDriver {


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"D:\\Joker\\inputFlow","D:\\Joker\\Out7"};

        Configuration conf = new Configuration();
        //1.获取job对象 配置提交到yarn上运行,windows和Linux变量不一致
        Job job = Job.getInstance(conf);

        //2.设置jar储存位置
        job.setJarByClass(FlowCountDriver.class);

        //3.关联Map和Reduce类
        job.setMapperClass(FlowCountMapper.class);
        job.setReducerClass(FlowCountReducer.class);

        //4.设置Mapper阶段输出数据的key和value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        //5.设置最终数据输出的key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //自定义Partition
        job.setPartitionerClass(ProvincePartitioner.class);
        job.setNumReduceTasks(5);


        //6.设置输入路径和输出路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //7.提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0:1);

    }

}