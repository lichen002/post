package com.test.exercise;

import com.api.entity.apply.ApplyInstall;
import lombok.SneakyThrows;

public class ThreadOne{
    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        for(int i=0;i<10;i++) {
            Thread thread = new Thread(myThread);
            thread.start();

        }

    }
}
class MyThread implements Runnable {
    indexage indexage = new indexage();
        public void run(){
            String name = Thread.currentThread().getName();
            String age= name.split("-")[1];
            if(age.equals(2)){
                indexage.getindexadd();
            }else if(age.equals(3)){
                indexage.getIndexreduce();
            }else {
                System.out.println(indexage.getIndex());

            }

        }
}

class indexage {
     static int index=0;

    indexage(){
        index++;
    }
    public void getindexadd(){
        ++index;

    }
    public void getIndexreduce(){
        index--;
    }

    public int getIndex(){
        return index;
    }




}

class Student {

    String name;
    int age;
    static int NoOfStudents = 0;

    Student(){
        NoOfStudents++;
    }

    public int getNoOfStudents(){
        return NoOfStudents;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


}


