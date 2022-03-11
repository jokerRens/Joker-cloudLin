package com.joker.designmode.facade;

/**
 * Computer
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 14:45
 **/

public class Computer {

    private CPU cpu;
    private Disk disk;
    private Mamore mamore;

    public Computer() {
        cpu = new CPU();
        disk = new Disk();
        mamore = new Mamore();
    }

    public void start(){
        System.out.println("computer start begin");
        cpu.start();
        disk.start();
        mamore.start();
        System.out.println("computer start end");
    }

    public void shutDown(){
        System.out.println("computer shutDown begin");
        cpu.shutDown();
        disk.shutDown();
        mamore.shutDown();
        System.out.println("computer shutDown end");
    }
}
