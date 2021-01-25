package com.api.entity.apply;

import lombok.Data;

@Data
public class ApplyInstall {
    private String machineCode;
    private long appId;
    private String appKey;
    private String source;
    private Integer eventType;
    private long userId;
    private String url;
    private String userCode;

    /**
     * {
     *         "machineCode": "0127180000260000000b",
     *             "appId": "2020082017270",
     *             "appKey": "app_2020082017274",
     *             "source": "2",
     *             "eventType": 1,
     *             "userId": "202005119668",
     *             "url": "/jeejio/install",
     *             "userCode": "jeejio_13"
     *     }
     */


}
