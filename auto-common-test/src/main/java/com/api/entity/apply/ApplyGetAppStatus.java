package com.api.entity.apply;

import lombok.Data;

@Data
public class ApplyGetAppStatus {
    public String appVersion;
    public String machineCode;
    public String appId;
    public String userId;
    public String userCode;
    public ApplyInstall applyInstall;

    /**
     * {
     * 	"appVersion": "888896",
     * 	"machineCode": "0127180000180000001d",
     * 	"appId": "20201113120400",
     * 	"userId": "202004031326",
     * 	"userCode": "jeejio_11488"
     * }
     */
}
