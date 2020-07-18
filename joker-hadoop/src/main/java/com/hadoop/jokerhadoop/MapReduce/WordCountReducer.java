package com.hadoop.jokerhadoop.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

/**
 * Reducer 阶段
 *  KEYIN , VALUEIN 对应mapper输出的KEYOUT, VALUEOUT类型
 *  KEYOUT，VALUEOUT 对应自定义reduce逻辑处理结果的输出数据类型 KEYOUT是单词 VALUEOUT是总次数
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

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
