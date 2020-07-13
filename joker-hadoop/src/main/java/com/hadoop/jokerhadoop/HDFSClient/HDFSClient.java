package com.hadoop.jokerhadoop.HDFSClient;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSClient {

    public static void main(String[] args) throws IOException {


        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://hadoop2:9000");
        //1.获取HDFS客户端对象
        System.setProperty("HADOOP_USER_NAME", "root");
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(conf);

        //2.在HDFS上创建路径
        fs.mkdirs(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker"));

        //3.关闭资源
        fs.close();

        System.out.println("成功");
    }

    //文件上传
    @Test
    public void  testCopyFromLocalFile() throws URISyntaxException, IOException, InterruptedException {
        //1.获取fs对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");

        //2.执行上传API
        fs.copyFromLocalFile(new Path("D:\\Hadoop\\joker.txt"),new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker"));

        //3.关闭资源
        fs.close();
    }

    //文件下载
    @Test
    public void testCopyToLocalFile() throws URISyntaxException, IOException, InterruptedException {
        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");
        //执行下载API
        fs.copyToLocalFile(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/joker.txt"),new Path("D:\\Hadoop\\joker1.txt"));

        //关闭资源
        fs.close();
    }


    //文件删除
    @Test
    public void testDelete() throws URISyntaxException, IOException, InterruptedException {
        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");
        //执行下载API
        fs.delete(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/joker.txt"),true);

        //关闭资源
        fs.close();
    }


    //文件更名
    @Test
    public void testRename() throws URISyntaxException, IOException, InterruptedException {
        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");
        //执行下载API
        fs.rename(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/joker.txt"),new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/xiatian.txt"));

        //关闭资源
        fs.close();
    }


    //查看文件详情
    @Test
    public void testFileInfo() throws URISyntaxException, IOException, InterruptedException {
        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");
        //执行下载API
        RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/"), true);
        while (iterator.hasNext()){
            LocatedFileStatus next = iterator.next();

            //查看文件名称、权限、长度、块信息、
            System.out.println(next.getPath().getName());//文件名称
            System.out.println(next.getPermission()); //文件权限
            System.out.println(next.getLen());//文件长度

            BlockLocation[] locations = next.getBlockLocations();
            for (BlockLocation location : locations) {
                String[] hosts = location.getHosts();
                    for (String host : hosts) {
                        System.out.println(host);
                    }
            }
            System.out.println("=========================xxx===========================");
        }
        //关闭资源
        fs.close();
    }


    //判断是文件还是文件夹
    @Test
    public void testFileState() throws URISyntaxException, IOException, InterruptedException {
        //1.获取对象
        Configuration conf = new Configuration();
        System.setProperty("hadoop.home.dir", "D:\\Hadoop\\hadoop-2.10.0");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop2:9000"), conf, "root");
        //执行下载API
        FileStatus[] statuses = fs.listStatus(new Path("/usr/local/hadoop/hadoop-2.10.0/wcinput/0707/joker/"));
        for (FileStatus status : statuses) {
            if(status.isFile()){
                //文件
                System.out.println("f:"+status.getPath().getName());
            }else{
                //文件夹
                System.out.println("d:"+status.getPath().getName());
            }
        }
        //关闭资源
        fs.close();
    }

}
