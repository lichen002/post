package com.api.entity.apply;

import lombok.Data;

@Data
public class GetAppStatus {
    private String appVersion;
    private String machineCode;
    private String appId;
    private String userId;
    private String userCode;
    /**
     * {
     * 	"appVersion": " 1.94",
     * 	"machineCode": "0127180000180000001d",
     * 	"appId": "20201212222492",
     * 	"userId": "202004031326",
     * 	"userCode": "jeejio_11488"
     * }
     */
}
