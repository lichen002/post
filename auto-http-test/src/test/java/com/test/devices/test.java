package com.test.devices;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.utils.utils;

import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {

        utils.applyReleaseNewVersion(1);

        String str = "[{\n" +
             "\t\"id\": 1,\n" +
             "\t\"name\": \"李晨\",\n" +
             "\t\"age\": 28\n" +
             "}, {\n" +
             "\t\"id\": 1,\n" +
             "\t\"name\": \"李晨\",\n" +
             "\t\"age\": 28\n" +
             "}, {\n" +
             "\t\"id\": 2,\n" +
             "\t\"name\": \"李晨2\",\n" +
             "\t\"age\": 28\n" +
             "}, {\n" +
             "\t\"id\": 3,\n" +
             "\t\"name\": \"李晨3\",\n" +
             "\t\"age\": 28\n" +
             "}]";

        JSONArray array = JSONObject.parseArray(str);
        ArrayList<Object> strings = new ArrayList<Object>();
        int[] arr = {1,2,3,4,5,1};
        int[] newarr = new int[arr.length];
        for (int i=0;i<array.size();i++){
                if(strings.contains(array.get(i))){
                    continue;
                }else {
                    strings.add(array.get(i));
                }

        }
        for (int i=0;i<strings.size();i++){
            System.out.println(strings.get(i));
        }

    }
}
