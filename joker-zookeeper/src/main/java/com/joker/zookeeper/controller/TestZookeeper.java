package com.joker.zookeeper.controller;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class TestZookeeper {

    private String connectString = "hadoop2:2181,hadoop3:2181,hadoop4:2181";

    private int sessionTimeout = 2000;

    private ZooKeeper zkClient;

//    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/", true);
                    for (String child : children) {
                        System.out.println(child);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
    }


    //1.创建子节点
    public void createNode() throws KeeperException, InterruptedException {
        String createPath = zkClient.create("/joker", "xiatian".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    //2.获取子节点 并监控节点变化

    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", false);

        for (String child : children) {
            System.out.println(child);
        }

        Thread.sleep(Long.MAX_VALUE);
    }

    //3.判断节点是否存在
    public void exist() throws KeeperException, InterruptedException {
        Stat exists = zkClient.exists("/joker", false);
        System.out.println(exists);
    }

}
