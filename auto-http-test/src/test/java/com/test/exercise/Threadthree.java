package com.test.exercise;

public class Threadthree {
    public static void main(String[] args) {
        for(int i=1;i<5;i++){
            Demo demo = new Demo();
            demo.start();
        }

    }
}

class Demo extends Thread{
    static int number = 100;
    public void run(){
        while (number>0) {
            System.out.println("卖到了第" + number + "张票");
            number--;
        }
    }
}
