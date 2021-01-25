package com.api.entity.devices;

import lombok.Data;

@Data
public class RelateMachineAndUser {
    private String machineCode;
    private String userId;
    private String userCode;
    private String machineType;

    /**
     * {
     * 	"machineCode": "0127180000180000001d",
     * 	"userId": "202004031326",
     * 	"userCode": "jeejio_11488",
     * 	"machineType": "1"
     * }
     */
}
