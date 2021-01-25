package com.api.entity.apply;

import lombok.Data;

@Data
public class ApplyOpen {
    private String machineCode;
    private long appId;
    private int themeId;
    private String appKey;
    private Integer source;
    private Integer eventType;
    private long userId;
    private String url;
    private String userCode;


    /**
     * {
     * 	"machineCode": "0127180000180000001d",
     * 	"appId": "2020081240194",
     * 	"themeId": 0,
     * 	"appKey": "app_2020081240198",
     * 	"eventType": 4,
     * 	"source": 1,
     * 	"userId": "202004031326",
     * 	"url": "/jeejio/?cmd\u003dstartactivity",
     * 	"userCode": "jeejio_11488"
     * }
     */


}
