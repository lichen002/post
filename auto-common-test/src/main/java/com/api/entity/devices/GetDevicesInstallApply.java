package com.api.entity.devices;

import lombok.Data;

@Data
public class GetDevicesInstallApply {
    private String machineCode;
    private int pageSize;
    private int pageNum;


    /**
     * {"machineCode":"0127180000180000001d","pageSize":16,"pageNum":1}
     */

}
