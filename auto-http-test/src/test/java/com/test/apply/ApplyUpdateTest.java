package com.test.apply;

import com.alibaba.fastjson.JSONObject;
import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.api.utils.utils;
import com.imlp.apply.ApplyServiceImlp;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.IOException;


@Slf4j
public class ApplyUpdateTest extends ApplyServiceImlp implements TestData, ApiPath {
    static long userId;
    static String userCode;
    @Resource
    ApplyServiceImlp applyServiceImlp;

    @BeforeClass
    public static void setUp() throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        log.info("userInfo is {}",userInfo);
        userCode =(String) userInfo.get("userCode");
        userId =(Long) userInfo.get("id");
    }


    //强制更新成功
    @Test
    public void testForceUpdate(){


    }
}
