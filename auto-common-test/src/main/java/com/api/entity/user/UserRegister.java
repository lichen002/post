package com.api.entity.user;

import lombok.Data;

@Data
public class UserRegister {
    private String userPhone;
    private String validateCode;
    private String sessionId;
    private String platform;
    private String tool;
    /**
     * {
     * 	"userPhone": "15701188230",
     * 	"validateCode": "136688",
     * 	"sessionId": "72CDF1F75C25F58235698F4CACD727403ADFA54F",
     * 	"platform": "control",
     * 	"tool": "2"
     * }
     */

}
