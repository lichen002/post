package com.imlp.devices;

import com.alibaba.fastjson.JSON;
import com.api.entity.devices.GetDevicesInstallApply;
import com.api.service.devices.GetDevicesInstallApplyService;

import java.io.IOException;

import static com.api.http.common.ApiPath.DEVICES_APPLY_INSTALL;
import static com.api.http.common.HttpDelegate.postAndToken;

public class GetDevicesInstallApplyImpl implements GetDevicesInstallApplyService {
    @Override
    public String getInstallApply(GetDevicesInstallApply getDevicesInstallApply) throws IOException {
        String request = JSON.toJSONString(getDevicesInstallApply);
        return postAndToken(DEVICES_APPLY_INSTALL,request);
    }
}
