package com.api.entity.apply.jeejio.open;

import lombok.Data;

@Data
public class PublistVersion {
    private long createUser;
    private long developerId;
    private long appId;
    private long packageId;
    private long resourceId;
    private String version;
    private int isContainWeb;
    private int isForce;
    private int isQuoteJmSdk;
    private int isQuoteJosSdk;
    private long installSize;
    private int updateContent;
    /**
     * {
     * 	"createUser": 202004031326,
     * 	"developerId": 202004036478,
     * 	"appId": 2020081840666,
     * 	"packageId": 20201126305832,
     * 	"resourceId": 20201126305764,
     * 	"version": "315",
     * 	"isContainWeb": 0,
     * 	"isForce": 0,
     * 	"isQuoteJmSdk": 0,
     * 	"isQuoteJosSdk": 0,
     * 	"installSize": 1598454,
     * 	"updateContent": "315"
     * }
     */
}
