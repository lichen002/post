package com.test.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.entity.login.LoginOpen;

import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.imlp.login.LoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;


@Slf4j
public class LoginTest implements TestData, ApiPath {
    LoginServiceImpl login = new LoginServiceImpl();

    @Test
    //手机号登录成功
    public void testPhoneLogin() throws IOException {
        LoginOpen loginOpen = new LoginOpen();
        loginOpen.setUserKey(TEST_ACCOUNT);
        loginOpen.setUserPasswd(TEST_PASSWORD);
        loginOpen.setPlatform("kf");
        loginOpen.setTool("1");
        String loginResult = login.login(loginOpen);
        JSONObject response = JSON.parseObject(loginResult);
        log.info("response is {}",response);
        JSONObject resultValue =(JSONObject) response.get("resultValue");
        Assert.assertEquals(TEST_PASS_SUCCESS,response.get("success"));
        Assert.assertEquals(TEST_PASS_CODE,response.get("statusCode"));

    }


    @Test
    //邮箱登陆成功
    public void testEmailLogin() throws IOException {
        LoginOpen loginOpen = new LoginOpen();
        loginOpen.setUserKey(TEST_EMAIL_ACCOUNT2);
        loginOpen.setUserPasswd(TEST_PASSWORD);
        loginOpen.setPlatform("kf");
        loginOpen.setTool("1");
        String loginResult = login.login(loginOpen);
        JSONObject response = JSON.parseObject(loginResult);
        log.info("response is {}",response);
        JSONObject resultValue =(JSONObject) response.get("resultValue");
        Assert.assertEquals(TEST_PASS_SUCCESS,response.get("success"));
        Assert.assertEquals(TEST_PASS_CODE,response.get("statusCode"));
    }


    @Test
    //验证账号不存在
    public void testAccountNoExist() throws IOException {
        LoginOpen loginOpen = new LoginOpen();
        loginOpen.setUserKey("15701188585");
        loginOpen.setUserPasswd(TEST_PASSWORD);
        loginOpen.setPlatform("kf");
        loginOpen.setTool("1");
        String loginResult = login.login(loginOpen);
        JSONObject response = JSON.parseObject(loginResult);
        log.info("response is {}",response);
        JSONObject resultValue =(JSONObject) response.get("resultValue");
        Assert.assertEquals(TEST_ERROR_SUCCESS,response.get("success"));
    }




}
