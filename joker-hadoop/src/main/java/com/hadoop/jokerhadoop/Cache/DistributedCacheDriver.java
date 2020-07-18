package com.hadoop.jokerhadoop.Cache;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DistributedCacheDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {

        //根据电脑配置
        args = new String[]{"D:\\Joker\\inputDemo7","D:\\Joker\\Out12"};

        Configuration conf = new Configuration();

        //1.获取job对象
        Job job = Job.getInstance(conf);

        //2.设置jar储存路径
        job.setJarByClass(DistributedCacheDriver.class);

        //3.关联mapper和reduce类
        job.setMapperClass(DistributedCacheMapper.class);

        //5.设置最终输出的key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        //6.设置输出路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //
        job.addCacheFile(new URI(""));

        //map端Join的逻辑不需要Reduce阶段、设置ReduceTask数量为0
        job.setNumReduceTasks(0);

        //7.提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0:1);

    }

}
