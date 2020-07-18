package com.hadoop.jokerhadoop.Cache;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.*;
import java.net.URI;
import java.util.HashMap;

public class DistributedCacheMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    HashMap<String, String> pdMap = new HashMap<>();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        //缓存小表
        URI[] files = context.getCacheFiles();
        String path = files[0].getPath().toString();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        String line;
        while(StringUtils.isNotEmpty(line = reader.readLine())){
                //1.切割
            String[] split = line.split("  ");
            pdMap.put(split[0],split[1]);
        }
        //2.关闭资源
        IOUtils.closeStream(reader);
    }

    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1.获取一行
        String line = value.toString();

        //2.切割
        String[] split = line.split("  ");

        //3.获取pid
        String pid = split[1];

        //4.取出
        String pname = pdMap.get(pid);

        //5.拼接
        line = line+"\t"+pname;

        k.set(line);
        //6.写出
        context.write(k,NullWritable.get());
    }
}
