package com.test.apply;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.entity.apply.ApplyClose;
import com.api.entity.apply.ApplyInstall;
import com.api.entity.apply.ApplyOpen;
import com.api.entity.apply.ApplyUnInstall;
import com.api.entity.devices.GetDevicesInstallApply;
import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.api.utils.utils;
import com.imlp.apply.ApplyServiceImlp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import static java.lang.Thread.sleep;


@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplyTest implements TestData, ApiPath {
    static long userId;
    static String userCode;
    ApplyServiceImlp applyServiceImlp = new ApplyServiceImlp();


    @BeforeClass
    public static void setUp() throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        log.info("userInfo is {}",userInfo);
        userCode =(String) userInfo.get("userCode");
        userId =(Long) userInfo.get("id");
    }



    //安装应用
    @Test
    @Order(1)
    public void testApplyInstall() throws IOException, InterruptedException {
        GetDevicesInstallApply getDevicesInstallApply = new GetDevicesInstallApply();
        getDevicesInstallApply.setMachineCode(TEST_MACHINE_CODE);
        getDevicesInstallApply.setPageNum(1);
        getDevicesInstallApply.setPageSize(10);
        log.info("getDevicesInstallApply is {}",getDevicesInstallApply.toString());
        JSONObject appResult = utils.getDevicesInstllApply(getDevicesInstallApply);
        log.info("appResult is {}",appResult);
        JSONObject resultList =(JSONObject)appResult.get("resultValue");
        JSONArray appList =(JSONArray) resultList.get("list");

        //清空设备上面安装的应用

        for (int i=4;i<appList.size();i++){
            ApplyUnInstall applyUnInstall = new ApplyUnInstall();
            JSONObject applist =(JSONObject) appList.get(i);
            long appId =(long) applist.get("appId");
            String appKey =(String) applist.get("appKey");
            applyUnInstall.setAppId(appId);
            applyUnInstall.setMachineCode(TEST_MACHINE_CODE);
            applyUnInstall.setAppKey(appKey);
            applyUnInstall.setEventType(APPLY_EVENTTYPE_UNINSTALL);
            applyUnInstall.setSource("2");
            applyUnInstall.setThemeId(0);
            applyUnInstall.setUrl("/jeejio/uninstall");
            applyUnInstall.setUserId(userId);
            applyUnInstall.setUserCode(userCode);
            utils.clearDevicesInstallApply(applyUnInstall);
        }


        //安装市场上第一个应用

        JSONObject appResultMarket = utils.getApplyList(TEST_MACHINE_CODE, "10008", userId, userCode);
        log.info("appResultMarket is {}",appResultMarket);
        JSONArray resultListMarket =(JSONArray)appResultMarket.get("resultList");

        for (int i=0;i<resultListMarket.size();i++){
            sleep(500);
            JSONObject lastApply =(JSONObject) resultListMarket.get(i);
            long appId =(long) lastApply.get("appId");
            String appKey =(String) lastApply.get("appKey");
            ApplyInstall applyInstall = new ApplyInstall();
            applyInstall.setAppId(appId);
            applyInstall.setAppKey(appKey);
            applyInstall.setEventType(APPLY_EVENTTYPE_INSTALL);
            applyInstall.setMachineCode(TEST_MACHINE_CODE);
            applyInstall.setSource("2");
            applyInstall.setUrl("/jeejio/install");
            applyInstall.setUserCode(userCode);
            applyInstall.setUserId(userId);
            String resultString =applyServiceImlp.applyInstall(applyInstall);
            log.info("resultString is {}",resultString);
            JSONObject resultJson = JSON.parseObject(resultString);
            JSONObject appResult2 = utils.getDevicesInstllApply(getDevicesInstallApply);
            log.info("appResult is {}",appResult2);
            JSONObject resultList2 =(JSONObject)appResult.get("resultValue");
            JSONArray appList2 =(JSONArray) resultList2.get("list");
    //        Assert.assertEquals(1,resultJson.get("success"));
//        Assert.assertEquals(5,appList2.size());

        }

    }

    //已经安装的应用不可再进行安装
    @Test
    @Order(2)
    public void testIsExistNotInstall() throws IOException {
        JSONObject appResult = utils.getApplyList(TEST_MACHINE_CODE, "10008", userId, userCode);
        log.info("appResult is {}",appResult);
        JSONArray resultList =(JSONArray)appResult.get("resultList");

        JSONObject lastApply =(JSONObject) resultList.get(0);
        long appId =(long) lastApply.get("appId");
        String appKey =(String) lastApply.get("appKey");
        ApplyInstall applyInstall = new ApplyInstall();
        applyInstall.setAppId(appId);
        applyInstall.setAppKey(appKey);
        applyInstall.setEventType(APPLY_EVENTTYPE_INSTALL);
        applyInstall.setMachineCode(TEST_MACHINE_CODE);
        applyInstall.setSource("2");
        applyInstall.setUrl("/jeejio/install");
        applyInstall.setUserCode(userCode);
        applyInstall.setUserId(userId);
        String resultString =applyServiceImlp.applyInstall(applyInstall);
        log.info("resultString is {}",resultString);
        JSONObject resultJson = JSON.parseObject(resultString);
        Assert.assertEquals(0,resultJson.get("success"));
        Assert.assertEquals("该应用已经在此设备下安装,不可再次安装",resultJson.get("message"));
    }


//    @ParameterizedTest
//    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
//    public void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
//        System.out.println(inputexpected);
//    }

    //开启应用
    @Test
    public void testApplyOpen() throws IOException, InterruptedException {
        GetDevicesInstallApply getDevicesInstallApply = new GetDevicesInstallApply();
        getDevicesInstallApply.setMachineCode(TEST_MACHINE_CODE);
        getDevicesInstallApply.setPageNum(1);
        getDevicesInstallApply.setPageSize(20);
        JSONObject appResult = utils.getDevicesInstllApply(getDevicesInstallApply);
        log.info("appResult is {}",appResult);
        JSONObject resultList =(JSONObject)appResult.get("resultValue");
        JSONArray appList =(JSONArray) resultList.get("list");

        ApplyServiceImlp applyServiceImlp = new ApplyServiceImlp();
        for (int i=4;i<appList.size();i++){

            JSONObject applist =(JSONObject) appList.get(i);
            long appId =(long) applist.get("appId");
            String appKey =(String) applist.get("appKey");
            ApplyOpen applyOpen = new ApplyOpen();
            applyOpen.setAppId(appId);
            applyOpen.setAppKey(appKey);
            applyOpen.setEventType(APPLY_EVENTTYPE_OPEN);
            applyOpen.setMachineCode(TEST_MACHINE_CODE);
            applyOpen.setSource(1);
            applyOpen.setThemeId(0);
            applyOpen.setUrl("/jeejio/?cmd\u003dstartactivity");
            applyOpen.setUserId(userId);
            applyOpen.setUserCode(userCode);
            String s1 = JSON.toJSONString(applyOpen);
            log.info("s1 is {}",s1);
            String s = applyServiceImlp.applyOpen(applyOpen);
            log.info("s is {}",s);
            sleep(2000);
            utils.getDevicesInstllApply(getDevicesInstallApply);


        }
    }

    //关闭应用
    @Test
    public void testApplyClose() throws IOException, InterruptedException {
        GetDevicesInstallApply getDevicesInstallApply = new GetDevicesInstallApply();
        getDevicesInstallApply.setMachineCode(TEST_MACHINE_CODE);
        getDevicesInstallApply.setPageNum(1);
        getDevicesInstallApply.setPageSize(20);

        JSONObject appResult = utils.getDevicesInstllApply(getDevicesInstallApply);
        log.info("appResult is {}", appResult);
        JSONObject resultList = (JSONObject) appResult.get("resultValue");
        JSONArray appList = (JSONArray) resultList.get("list");

        ApplyServiceImlp applyServiceImlp = new ApplyServiceImlp();
        for (int i = 4; i < appList.size(); i++) {

            JSONObject applist = (JSONObject) appList.get(i);
            long appId = (long) applist.get("appId");
            String appKey = (String) applist.get("appKey");

            ApplyClose applyClose = new ApplyClose();
            applyClose.setAppId(appId);
            applyClose.setAppKey(appKey);
            applyClose.setEventType(APPLY_EVENTTYPE_CLOSE);
            applyClose.setMachineCode(TEST_MACHINE_CODE);
            applyClose.setSource(1);
            applyClose.setThemeId(0);
            applyClose.setUrl("/jeejio/?cmd\u003dstopapp");
            applyClose.setUserId(userId);
            applyClose.setUserCode(userCode);
            String s1 = JSON.toJSONString(applyClose);
            log.info("s1 is {}", s1);
            String s = applyServiceImlp.applyClose(applyClose);
            log.info("s is {}", s);
            sleep(2000);
            utils.getDevicesInstllApply(getDevicesInstallApply);
        }

    }

    @Test
    //清空应用
    public void testApplyClear() throws IOException {
        GetDevicesInstallApply getDevicesInstallApply = new GetDevicesInstallApply();
        getDevicesInstallApply.setMachineCode(TEST_MACHINE_CODE);
        getDevicesInstallApply.setPageNum(1);
        getDevicesInstallApply.setPageSize(20);
        JSONObject appResult = utils.getDevicesInstllApply(getDevicesInstallApply);
        log.info("appResult is {}",appResult);
        JSONObject resultList =(JSONObject)appResult.get("resultValue");
        JSONArray appList =(JSONArray) resultList.get("list");

        //清空设备上面安装的应用

        for (int i=4;i<appList.size();i++){
            ApplyUnInstall applyUnInstall = new ApplyUnInstall();
            JSONObject applist =(JSONObject) appList.get(i);
            long appId =(long) applist.get("appId");
            String appKey =(String) applist.get("appKey");
            applyUnInstall.setAppId(appId);
            applyUnInstall.setMachineCode(TEST_MACHINE_CODE);
            applyUnInstall.setAppKey(appKey);
            applyUnInstall.setEventType(APPLY_EVENTTYPE_UNINSTALL);
            applyUnInstall.setSource("2");
            applyUnInstall.setThemeId(0);
            applyUnInstall.setUrl("/jeejio/uninstall");
            applyUnInstall.setUserId(userId);
            applyUnInstall.setUserCode(userCode);
            utils.clearDevicesInstallApply(applyUnInstall);
        }
    }
}
