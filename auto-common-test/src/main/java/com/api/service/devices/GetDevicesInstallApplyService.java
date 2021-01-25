package com.api.service.devices;

import com.api.entity.devices.GetDevicesInstallApply;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface GetDevicesInstallApplyService {
    public String getInstallApply(GetDevicesInstallApply getDevicesInstallApply) throws IOException;
}
