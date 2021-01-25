package com.test.exercise;

public class DemoPay {
    public static void main(String[] args) throws InterruptedException {
        dopay dopay = new dopay();
        Thread t1 = new Thread(dopay);
        Thread t2 = new Thread(dopay);
        t1.start();
        t2.start();
        Thread.sleep(2000);
        dopay.donotify();


    }
}

class dopay implements Runnable {
    int money = 1000;
    int action = 600;
    public  void run(){
        if(money<600){
            System.out.println(Thread.currentThread().getName()+"余额不足转账失败");

        }else {
            System.out.println(Thread.currentThread().getName()+"转账"+action);

            System.out.println(Thread.currentThread().getName()+"剩余为"+(money=money-action));
        }
//        try {
//            this.wait();
//            System.out.println("被唤起");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }

    public synchronized void donotify(){
        this.notify();
    }
}
