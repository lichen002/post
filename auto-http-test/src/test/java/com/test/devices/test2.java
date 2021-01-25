package com.test.devices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test2 {
    public static void main(String[] args) throws IOException {
//        System.out.println("E:\\com.dev.java\\jeejio-java\\auto-http-test\\src\\test\\resources\\test\\applydata\\login\\testdata.csv");
//        String adbHome="/Users/Dell/AppData/Local/Android/Sdk/platform-tools";
//        String cmd=adbHome+"adb version";
//        Process process;
//
//        try {
//            process=Runtime.getRuntime().exec(cmd);
//            System.out.println(InputStream2String(process.getInputStream()));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        appCmd("adb shell svc wifi enable");



    }

    public String setup(String pash){
        String path = this.getClass().getClassLoader().getResource(pash).getPath();
        return path;

    }

    public static String InputStream2String(InputStream inputStream){
        String result="";
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        try {
            String temp="";
            while ((temp=br.readLine())!=null){
                result+=temp+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void appCmd(String cmd) throws IOException {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = null;
        BufferedReader ie = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String error = null;

        while ((error = ie.readLine()) != null
                && !error.equals("null")) {
            data += error + "\n";
        }

        String line = null;
        while ((line = in.readLine()) != null
                && !line.equals("null")) {
            data += line + "\n";
        }

    }
}
