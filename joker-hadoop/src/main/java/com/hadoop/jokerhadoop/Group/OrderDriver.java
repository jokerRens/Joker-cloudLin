package com.hadoop.jokerhadoop.Group;

import com.hadoop.jokerhadoop.Sort.FlowBean;
import com.hadoop.jokerhadoop.Sort.SortDriver;
import com.hadoop.jokerhadoop.Sort.SortMapper;
import com.hadoop.jokerhadoop.Sort.SortReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class OrderDriver {


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"D:\\Joker\\inputDemo4","D:\\Joker\\Out9"};

        Configuration conf = new Configuration();

        //1.获取job对象
        Job job = Job.getInstance(conf);

        //2.设置jar储存路径
        job.setJarByClass(OrderDriver.class);

        //3.关联mapper和reduce类
        job.setMapperClass(OrderMapper.class);
        job.setReducerClass(OrderReducer.class);

        //4.设置mapper输出的key和value类型
        job.setMapOutputKeyClass(OrderBean.class);
        job.setMapOutputValueClass(NullWritable.class);

        //5.设置最终输出的key和value类型
        job.setOutputKeyClass(OrderBean.class);
        job.setOutputValueClass(NullWritable.class);

        //6.设置输出路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //设置分组
        job.setGroupingComparatorClass(OrderGroupingComparator.class);

        //7.提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0:1);



    }

}
