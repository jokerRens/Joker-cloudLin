package com.joker.zookeeper.controller;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

public class DistributeServer {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        DistributeServer server = new DistributeServer();


        //1.连接zookeeper集群
        server.getConnect();
        //2.注册节点
        server.regist(args[0]);
        //3.业务逻辑处理
        server.business();

    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        zkClient.create("/joker/server",hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
    }

    private String connectString = "hadoop2:2181,hadoop3:2181,hadoop4:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;
    private void getConnect() throws IOException {

        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher(){
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }





}
