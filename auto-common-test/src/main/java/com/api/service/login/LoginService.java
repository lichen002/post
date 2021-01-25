package com.api.service.login;


import com.api.entity.login.LoginOpen;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface LoginService {

     public String login(LoginOpen loginOpen) throws IOException;

}
