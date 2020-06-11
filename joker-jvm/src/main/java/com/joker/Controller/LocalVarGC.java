package com.joker.Controller;

public class LocalVarGC {


    public static void main(String[] args) {
        LocalVarGC varGC = new LocalVarGC();
        varGC.localVarGC5();
    }

    public void localVarGC1(){
        byte[] bytes = new byte[10 * 1024 * 1024]; //10MB
        System.gc();
    }

    public void localVarGC2(){
        byte[] bytes = new byte[10 * 1024 * 1024]; //10MB
        bytes = null;
        System.gc();
    }

    public void localVarGC3(){
        {
          byte[] bytes = new byte[10 * 1024 * 1024]; //10MB
        }
        System.gc();
    }

    public void localVarGC4(){
        {
            byte[] bytes = new byte[10 * 1024 * 1024]; //10MB
        }
        int value = 10;
        System.gc();
    }

    public void localVarGC5(){
        localVarGC1();
        System.gc();
    }


}
