package com.test.exercise;

public class ThreadFour {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        for(int i=0;i<200;i++){
            Thread thread = new Thread(demo2);
            thread.start();
        }

    }
}

class Demo2 implements Runnable{
    static int number=100;
    @Override
    public  void run() {
        while (true){
            if(number>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "窗口@销售："
                        + number + "号票");
            number--; }

            else {
                System.out.println("票买完了");
                break;
            }
        }
    }
}
