package com.joker.Controller;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * 查看直接内存的占用与释放
 */
public class BufferTest {

    private static final  int BUFFER = 1024*1024*1024; //1GB

    public static void main(String[] args){
        //直接分配本地内存空间
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
        System.out.println("直接内存分配完毕！");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放!");
        buffer=null;
        System.gc();
        scanner.next();
    }

}
