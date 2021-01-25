package com.api.entity.apply.jeejio.review;

import lombok.Data;

@Data
public class AppChangeClaim {
    private long qualiReviewId;
    private long appId;
    private long createUser;
    private String operatorName;
    /**
     * {
     * 	"qualiReviewId": 20201128100428,
     * 	"appId": 2020081840666,
     * 	"createUser": 202001042058,
     * 	"operatorName": "易烊千玺"
     * }
     */
}
