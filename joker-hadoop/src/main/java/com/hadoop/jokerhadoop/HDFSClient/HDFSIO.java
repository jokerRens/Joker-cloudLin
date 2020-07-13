package com.hadoop.jokerhadoop.HDFSClient;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSIO {


    //文件IO流上传文件
    @Test
    public void putFileToIO() throws URISyntaxException, IOException, InterruptedException {

        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");

        //2.获取输入流
        FileInputStream fis = new FileInputStream(new File("D:\\Hadoop\\xiatian.txt"));

        //3.获取输出流
        FSDataOutputStream fos = fs.create(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/xiatian.txt"));

        //4.流的对拷
        IOUtils.copyBytes(fis,fos,conf);

        //5.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }


    //文件IO流下载文件
    @Test
    public void getFileToIO() throws URISyntaxException, IOException, InterruptedException {

        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");

        //2.获取输入流
        FSDataInputStream fis = fs.open(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/xiatian.txt"));

        //3.获取输出流
        FileOutputStream fos = new FileOutputStream(new File("D:\\Hadoop\\xiatian1.txt"));

        //4.流的对拷
        IOUtils.copyBytes(fis,fos,conf);

        //5.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    //定位文件读取  下载第一块
    @Test
    public void readFileSeek1() throws URISyntaxException, IOException, InterruptedException {

        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");

        //2.获取输入流
        FSDataInputStream fis = fs.open(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/xiatian.txt"));

        //3.获取输出流
        FileOutputStream fos = new FileOutputStream(new File("D:\\Hadoop\\xiatian1.txt"));

        //4.流的对拷(只拷贝128m)
        byte[] bytes = new byte[1024];
        for (int i=0;i<1024 * 128;i++){
            fis.read(bytes);
            fos.write(bytes);
        }

        //5.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();

    }


    //定位文件读取  下载第二块
    @Test
    public void readFileSeek2() throws URISyntaxException, IOException, InterruptedException {

        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");

        //2.获取输入流
        FSDataInputStream fis = fs.open(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/xiatian.txt"));


        //3.设置指定读取的起点
        fis.seek(1024*1024*128);

        //4.获取输出流
        FileOutputStream fos = new FileOutputStream(new File("D:\\Hadoop\\xiatian1.txt"));


        //5.流的对拷
        IOUtils.copyBytes(fis,fos,conf);

        //6.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();

    }



}
