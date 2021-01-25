package com.test.devices;

import com.alibaba.fastjson.JSONObject;
import com.api.entity.devices.DevicesList;
import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.api.utils.utils;
import com.imlp.devices.DevicesListServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class DevicesListTest implements TestData, ApiPath {

         DevicesListServiceImpl devicesListService =   new DevicesListServiceImpl();


         @Test
    public void testDevicesList() throws IOException {
             DevicesList devicesList = new DevicesList();
             JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
             log.info("userInfo is {}",userInfo);
             String userCode =(String) userInfo.get("userCode");
             Long userId =(Long) userInfo.get("id");
             devicesList.setUserCode(userCode);
             devicesList.setUserId(userId);
             String devicesListResult = devicesListService.devicesList(devicesList);
             log.info("devicesListResult is {}",devicesListResult);



         }
}
