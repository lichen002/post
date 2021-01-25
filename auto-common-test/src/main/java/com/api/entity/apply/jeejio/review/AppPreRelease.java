package com.api.entity.apply.jeejio.review;

import lombok.Data;

@Data
public class AppPreRelease {
    private long createUser;
    private String operatorName;
    private long appId;
    private long qualiReviewId;

    /**
     * {
     * 	"createUser": 202001042058,
     * 	"operatorName": "易烊千玺",
     * 	"appId": 2020081840666,
     * 	"qualiReviewId": 20201130205388
     * }
     */
}
