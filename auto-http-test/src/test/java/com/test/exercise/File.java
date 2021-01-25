package com.test.exercise;

import com.api.utils.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class File {
    public static void main(String[] args) throws IOException {
        List<String> strings = utils.readFileByLine("login/file.txt");
        for(String str: strings){
            System.out.println(str);
        }

    }
}
