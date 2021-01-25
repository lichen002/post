package com.imlp.login;

import com.alibaba.fastjson.JSON;
import com.api.entity.login.LoginOpen;
import com.api.service.login.LoginService;

import java.io.IOException;

import static com.api.http.common.ApiPath.LOGIN_PATH;
import static com.api.http.common.HttpDelegate.post;

public class LoginServiceImpl implements LoginService {
    @Override
    public String login(LoginOpen loginOpen) throws IOException {
        String requestString = JSON.toJSONString(loginOpen);
        return post(LOGIN_PATH,requestString);
    }
}
