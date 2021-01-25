package com.api.entity.apply;

import lombok.Data;

@Data
public class ApplyUpdate {
    private String machineCode;
    private long appId;
    private int themeId;
    private String appKey;
    private int source;
    private Integer eventType;
    private long userId;
    private String url;
    private String userCode;

    /**
     * {
     * 	"machineCode": "0127180000180000001d",
     * 	"appId": "2020081840666",
     * 	"themeId": 0,
     * 	"appKey": "app_2020081840670",
     * 	"eventType": 3,
     * 	"source": 1,
     * 	"userId": "202004031326",
     * 	"url": "/jeejio/install",
     * 	"userCode": "jeejio_11488"
     * }
     */

}
