package com.test.exercise;

class Boy {

    String name;
    int age;
    String gender;
    // 构造代码块,给所有对象进行初始化。
    {
        System.out.println("哭。。。");
    }

    Boy() {
        System.out.println("无参构造");
    }

    Boy(String n, int a, String g) {
        name = n;
        age = a;
        gender = g;
        System.out.println("有参构造");
    }

    void run() {
        System.out.println("跑...");
    }

}

class Demo9 {

    public static void main(String[] args) {

        System.out.println();
        Boy b = new Boy();

        Boy b2 = new Boy("jack", 1, "男");

    }
}