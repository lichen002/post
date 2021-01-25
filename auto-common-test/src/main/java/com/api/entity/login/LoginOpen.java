package com.api.entity.login;

import lombok.Data;


@Data
public class LoginOpen {
    private String userKey;
    private String userPasswd;
    private String platform;
    private String tool;

}
