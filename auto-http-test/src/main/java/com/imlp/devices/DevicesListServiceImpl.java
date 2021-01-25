package com.imlp.devices;

import com.alibaba.fastjson.JSON;
import com.api.entity.devices.DevicesList;
import com.api.entity.devices.GetDevicesInfo;
import com.api.service.devices.DevicesListService;

import java.io.IOException;

import static com.api.http.common.ApiPath.DEVICES_INFO;
import static com.api.http.common.ApiPath.DEVICES_LIST;
import static com.api.http.common.HttpDelegate.postAndToken;

public class DevicesListServiceImpl implements DevicesListService {
    @Override
    public String devicesList(DevicesList devicesList) throws IOException {
        String request = JSON.toJSONString(devicesList);
        return postAndToken(DEVICES_LIST,request);
    }

    @Override
    public String getDevicesInfo(GetDevicesInfo getDevicesInfo) throws IOException {
        String request = JSON.toJSONString(getDevicesInfo);
        return postAndToken(DEVICES_INFO,request);
    }
}
