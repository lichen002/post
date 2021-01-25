package com.api.entity.apply.jeejio.review;

import lombok.Data;

@Data
public class AppCheckPass {
    private long createUser;
    private String operatorName;
    private long appId;
    private long qualiReviewId;
    private int appLevel;
    private int verifyDesc;
    /**
     * {
     * 	"createUser": 202001042058,
     * 	"operatorName": "易烊千玺",
     * 	"appId": 2020081840666,
     * 	"qualiReviewId": 20201128100428,
     * 	"appLevel": "3",
     * 	"verifyDesc": "123"
     * }
     */
}
