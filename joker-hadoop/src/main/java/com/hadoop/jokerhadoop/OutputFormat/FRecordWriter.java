package com.hadoop.jokerhadoop.OutputFormat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class FRecordWriter extends RecordWriter<Text, NullWritable> {

    FSDataOutputStream fosjoker;
    FSDataOutputStream fosOther;
    public FRecordWriter(TaskAttemptContext job) {
        try {
            //1.获取文件系统
            FileSystem fs = FileSystem.get(job.getConfiguration());
            //2.创建输出到joker.log的输出流
             fosjoker = fs.create(new Path("D:\\Joker\\joker"));
            //3.创建输出到other.log的输出流
             fosOther = fs.create(new Path("D:\\Joker\\other"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Text text, NullWritable nullWritable) throws IOException, InterruptedException {
            //判断key当中是否有joker，如果有写到joker.log  如果没有则other.log
            if(text.toString().contains("joker")){
                //joker输出流
                fosjoker.write(text.toString().getBytes());
            }else{
                fosOther.write(text.toString().getBytes());
            }
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        IOUtils.closeStream(fosjoker);
        IOUtils.closeStream(fosOther);
    }
}
