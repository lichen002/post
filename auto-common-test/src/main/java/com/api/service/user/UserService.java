package com.api.service.user;

import com.api.entity.user.JudgeUserExistOpen;
import com.api.entity.user.SetUserInfoOpen;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface UserService {
    public String setUserInfo(SetUserInfoOpen setUserInfoOpen) throws IOException;
    public String judgeUserExist(JudgeUserExistOpen judgeUserExistOpen) throws IOException;
}
