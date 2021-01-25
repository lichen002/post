package com.imlp.user.info;

import com.alibaba.fastjson.JSON;
import com.api.entity.user.JudgeUserExistOpen;
import com.api.entity.user.SetUserInfoOpen;
import com.api.service.user.UserService;

import java.io.IOException;

import static com.api.http.common.ApiPath.GET_USER_INFO;
import static com.api.http.common.ApiPath.SET_USER_INFO;
import static com.api.http.common.HttpDelegate.post;
import static com.api.http.common.HttpDelegate.postAndToken;

public class UserInfoImpl implements UserService {
    @Override
    public String setUserInfo(SetUserInfoOpen setUserInfoOpen) throws IOException {
        String request = JSON.toJSONString(setUserInfoOpen);
        return postAndToken(SET_USER_INFO,request);

    }

    @Override
    public String judgeUserExist(JudgeUserExistOpen judgeUserExistOpen) throws IOException {
        String request = JSON.toJSONString(judgeUserExistOpen);
        return post(GET_USER_INFO,request);
    }
}
