package com.test.exercise;

public class ThreadTwo {
    public static void main(String[] args) {
        for (int i=1;i<=3;i++) {
            ThreadTest threadTest = new ThreadTest(i*100);

            threadTest.start();
        }

    }


}
class ThreadTest extends Thread{
    int index;
     action a = new action();
    public ThreadTest(int index){
        this.index=index;
    }
    public void run(){
        for (int i=1;i<100;i++) {
            this.index++;
            long startTime = System.currentTimeMillis();
            a.dupost();
            long endTime = System.currentTimeMillis();
            System.out.println((float)endTime-startTime);
        }
    }
}

class action{
    public synchronized void dupost(){
        System.out.println("这是一个线程" +"-"+this.hashCode());

    }

}