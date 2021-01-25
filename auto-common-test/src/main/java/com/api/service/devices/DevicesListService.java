package com.api.service.devices;

import com.api.entity.devices.DevicesList;
import com.api.entity.devices.GetDevicesInfo;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface DevicesListService {
    public String devicesList(DevicesList devicesList) throws IOException;
    public String getDevicesInfo(GetDevicesInfo getDevicesInfo) throws IOException;

}
