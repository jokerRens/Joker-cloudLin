package com.hadoop.jokerhadoop.JokerInputFormat;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;
import java.util.List;

public class JokerInputFormat extends InputFormat<Text, BytesWritable> {


    @Override
    public List<InputSplit> getSplits(JobContext jobContext) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public RecordReader<Text, BytesWritable> createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {

        JokerRecordReader reader = new JokerRecordReader();
        reader.initialize(split,context);


        return null;
    }
}
