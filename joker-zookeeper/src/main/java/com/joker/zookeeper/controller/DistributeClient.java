package com.joker.zookeeper.controller;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributeClient {


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeClient client = new DistributeClient();
        //1.获取zookeeper集群连接
            client.getConnect();
        //2.注册监听
            client.getChlidren();
        //3.业务逻辑处理
            client.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getChlidren() throws KeeperException, InterruptedException {

        List<String> children = zkClient.getChildren("/server", true);
        //储存服务器节点名称集合
        ArrayList<String> hosts = new ArrayList<>();
        for (String child : children) {
            byte[] data = zkClient.getData("/server/" + child, false, null);
            hosts.add(new String(data));
        }
        //将所有在线主机名称打印到控制台
        System.out.println(hosts);

    }


    private String connectString = "hadoop2:2181,hadoop3:2181,hadoop4:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;
    private void getConnect() throws IOException {

        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher(){
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getChlidren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
