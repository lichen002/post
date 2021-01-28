package com.test.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.entity.user.JudgeUserExistOpen;
import com.api.entity.user.SetUserInfoOpen;
import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.api.utils.utils;
import com.imlp.user.info.UserInfoImpl;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Thread.sleep;

@Slf4j
public class UserInfoTest implements TestData, ApiPath {
    static long userId;
    static String userCode;
    String path;
    UserInfoImpl UserInfoImlp = new UserInfoImpl();

    @BeforeClass
    public void setUp() throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        log.info("userInfo is {}",userInfo);
        userCode =(String) userInfo.get("userCode");
        userId =(Long) userInfo.get("id");

    }

    @DataProvider(name="iterator")
    public Iterator<Object[]> dp() throws IOException {
        ArrayList<Object> item = new ArrayList<>();
        List<String> strings = utils.readFileByLine("test/applydata/login/testdata.csv");
        for(String str: strings){
            SetUserInfoOpen setUserInfoOpen = new SetUserInfoOpen();
            setUserInfoOpen.setUserName(str);
            setUserInfoOpen.setImgUrl("https://qauserimgs.jeejio.com/qa/202004031326/userinfo/2020-10-19/be710d73eb324d91928223e02a591310.jpg");
            setUserInfoOpen.setStatus(2);
            setUserInfoOpen.setUserBirth("2020-06-18");
            setUserInfoOpen.setUserId(userId);
            log.info("iteratorUser is {}",JSON.toJSONString(setUserInfoOpen));
            item.add(setUserInfoOpen);
        }
        List<Object[]> users = new ArrayList<Object[]>();
        for(Object u: item){
            users.add(new Object[]{u});
        }

        return users.iterator();
    }


    @Test(dataProvider="iterator")
    //更改用户信息
    public void testSetUserInfo(SetUserInfoOpen user) throws IOException, InterruptedException {
        System.out.println(user.getUserName());
        SetUserInfoOpen setUserInfoOpen = new SetUserInfoOpen();
        sleep(3000);
        setUserInfoOpen.setUserName(user.getUserName());
        setUserInfoOpen.setImgUrl(user.getImgUrl());
        setUserInfoOpen.setStatus(user.getStatus());
        setUserInfoOpen.setUserBirth(user.getUserBirth());
        setUserInfoOpen.setUserId(user.getUserId());
        log.info("setUserInfoOpen is {}", JSON.toJSONString(setUserInfoOpen));
        String result = UserInfoImlp.setUserInfo(setUserInfoOpen);
        log.info("result is {}",result);

        JudgeUserExistOpen judgeUserExistOpen = new JudgeUserExistOpen();
        judgeUserExistOpen.setUserKey(TEST_ACCOUNT);
        judgeUserExistOpen.setStatus("2");
        String resultInfo = UserInfoImlp.judgeUserExist(judgeUserExistOpen);
        log.info("resultInfo is {}",resultInfo);



    }












}
