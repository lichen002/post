package com.test.exercise;

public class java {
    public static void main(String[] args) {
        //线程安全synchronized修饰的方法
        StringBuffer stringBuffer = new StringBuffer("chenli29");
        System.out.println(stringBuffer.capacity());
        //使用replace方法进行替换
        stringBuffer.replace(2,3,"ji");
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.reverse());
        CharSequence charSequence = stringBuffer.subSequence(0, 1);
        System.out.println(charSequence.toString());



        //线程不安全的
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.capacity());


        StringBuffer stringBuffer1 = new StringBuffer("*");
        for (int i=1;i<=9;i++){
            System.out.println();
            for(int j=1;j<i+1;j++){
                System.out.print(" "+j+"*"+i+"="+j*i);

            }

        }
    }
}
