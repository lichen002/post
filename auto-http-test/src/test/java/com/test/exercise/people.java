package com.test.exercise;

public class people {
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public people(String name, int age) {
        name = name;
        age = age;
    }


    public people() {

    }

    private String name;
    private int age;

    public void tell(){
        System.out.println("姓名"+name+","+"年龄"+age);
    }

    public boolean compare(people p){
        System.out.println(this.age);
        System.out.println(p.age);

        return this.age==p.age;
    }


}

class ThisDemo{
    public static void main(String[] args) {
        people p1 = new people();
        people p2 = new people();
        p1.setAge(10);
        p2.setAge(20);
        boolean compare = p2.compare(p1);
        System.out.println(compare);


    }
}



