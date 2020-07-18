package com.hadoop.jokerhadoop.Writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProvincePartitioner extends Partitioner<Text, FlowBean> {
    @Override
    public int getPartition(Text text, FlowBean value, int i) {

        //text 手机号  value 流量信息

        //获取手机号前三位
        String phoneNumber = text.toString().substring(0, 3);

        int partition = 4;
        if("136".equals(phoneNumber)){
            partition = 0;
        }else if("137".equals(phoneNumber)){
            partition = 1;
        }else if("138".equals(phoneNumber)){
            partition = 2;
        }else if("139".equals(phoneNumber)){
            partition = 3;
        }
        return partition;
    }
}
