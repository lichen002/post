package com.api.entity.apply;

import lombok.Data;

@Data
public class ApplyUnInstall {
    private String machineCode;
    private long appId;
    private int themeId;
    private String appKey;
    private String source;
    private Integer eventType;
    private long userId;
    private String url;
    private String userCode;
    /**
     *     {
     *         "machineCode": "0127180000260000000b",
     *             "appId": "202008212856",
     *             "themeId": 0,
     *             "appKey": "app_202008212860",
     *             "eventType": 2,
     *             "source": 1,
     *             "userId": "202005119668",
     *             "url": "/jeejio/uninstall",
     *             "userCode": "jeejio_13"
     *     }
     */

}
