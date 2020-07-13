package com.hadoop.jokerhadoop.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;
import java.io.IOException;

/**
 * Reducer 阶段
 *  KEYIN:
 *  VALUEIN:
 *  KEYOUT:
 *  VALUEOUT:
 *
 */
public class WordCountReduce extends Reducer<Text, IntWritable,Text,IntWritable> {

    IntWritable v = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        super.reduce(key, values, context);
        /**
         * joker,1
         * joker,1
         */
        int sum = 0;
        //1.累加求和
        for (IntWritable value:values){
            sum += value.get();
        }
        v.set(sum);

        //2.写出  joker 2
        context.write(key,v);
    }
}
