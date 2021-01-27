package com.test.devices;

import com.alibaba.fastjson.JSONObject;
import com.api.entity.devices.GetDevicesInfo;
import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.api.utils.utils;
import com.imlp.devices.DevicesListServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mockito;
import org.testng.Assert;

import java.io.IOException;


@Slf4j
public class GetDevicesInfoTest implements TestData, ApiPath {
    static long userId;
    static String userCode;
    DevicesListServiceImpl devicesListService =new DevicesListServiceImpl();

//    @BeforeEach
    public  void setUp() throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        log.info("userInfo is {}",userInfo);
        userCode =(String) userInfo.get("userCode");
        userId =(Long) userInfo.get("id");

    }

//    @ParameterizedTest
//    @CsvFileSource(resources ="/data/test/devices/getdevicesinfo.csv",numLinesToSkip = 1)
    public void getOnlineDevicesInfo(String machineCode) throws IOException {
        GetDevicesInfo getDevicesInfo = new GetDevicesInfo();
        getDevicesInfo.setMachineCode(machineCode);
        getDevicesInfo.setUserCode(userCode);
        String request = JSONObject.toJSONString(getDevicesInfo);
        log.info("request is {}",request);
        String devicesInfo = devicesListService.getDevicesInfo(getDevicesInfo);
        log.info("devicesInfo is {}",devicesInfo);
        JSONObject resultJson  = JSONObject.parseObject(devicesInfo);
        JSONObject resultValue =(JSONObject) resultJson.get("resultValue");
        Integer isOnLine =(Integer) resultValue.get("isOnLine");
        String wifiUrl =(String) resultValue.get("wifiUrl");
        String batteryUrl =(String) resultValue.get("batteryUrl");
        String logo =(String) resultValue.get("logo");
        Assert.assertEquals(Integer.valueOf(1),isOnLine);
        Assert.assertNotNull(wifiUrl);
        Assert.assertNotNull(batteryUrl);
        Assert.assertNotNull(logo);

    }

//    @ParameterizedTest
//    @CsvFileSource(resources ="/data/test/devices/getdevicesinfo.csv",numLinesToSkip = 1)
    public void getOfflineDevicesInfo(String machineCode) throws IOException {
        String mockResult ="{\"code\":101,\"message\":\"invalid parameter\",\"requestId\":\"1234567890\",\"data\":{\"asrResult\":\"null\"}}";
        Mockito.when(devicesListService.getDevicesInfo(Mockito.any(GetDevicesInfo.class))).thenReturn(mockResult);

        GetDevicesInfo getDevicesInfo = new GetDevicesInfo();
        getDevicesInfo.setMachineCode(machineCode);
        getDevicesInfo.setUserCode(userCode);
        String request = JSONObject.toJSONString(getDevicesInfo);
        log.info("request is {}",request);
        String devicesInfo = devicesListService.getDevicesInfo(getDevicesInfo);
        log.info("devicesInfo is {}",devicesInfo);

    }



}
