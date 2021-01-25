package com.api.entity.apply.jeejio.review;

import lombok.Data;

@Data
public class AppGetChangeList {
    private long createUser;
    private int pageNum;
    private int pageSize;
    private String option;
    private String state;
    private String developerName;
    private String appName;
    /**
     * {
     * 	"createUser": 202001042058,
     * 	"pageNum": 1,
     * 	"pageSize": 10,
     * 	"option": "",
     * 	"state": "",
     * 	"developerName": "",
     * 	"appName": ""
     * }
     *
     *
     */
}
