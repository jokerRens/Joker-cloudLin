package com.joker.designmode.facade;

/**
 * CPU
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 14:42
 **/

public class CPU {

    public void start(){
        System.out.println("cpu is start...");
    }

    public void shutDown(){
        System.out.println("cpu is shutDown...");
    }
}

class Disk{
    public void start(){
        System.out.println("Disk is start...");
    }

    public void shutDown(){
        System.out.println("Disk is shutDown...");
    }
}

class Mamore{
    public void start(){
        System.out.println("Memory is start...");
    }

    public void shutDown(){
        System.out.println("Memory is shutDown...");
    }
}

