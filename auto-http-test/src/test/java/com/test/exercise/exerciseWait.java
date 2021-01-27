package com.test.exercise;

import lombok.SneakyThrows;

public class exerciseWait {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();


    }

}

class T1 extends Thread{
    Object object= new Object();
    public void run(){
        System.out.println(System.currentTimeMillis()+" :T1 启动!");

        try {
            System.out.println(System.currentTimeMillis()+"T1线程运行");
            object.wait();
            System.out.println(System.currentTimeMillis()+"T1线程被唤醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+" T1 end");

    }

}

class T2 extends Thread{
    Object object= new Object();
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis()+" :T2 启动!");

        System.out.println(System.currentTimeMillis()+"T2随机通知一条线程");
        object.notify();
        System.out.println(System.currentTimeMillis()+"T2end");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}