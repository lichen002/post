package com.api.entity.user;

import lombok.Data;

@Data
public class SetUserInfoOpen {
    private String imgUrl;
    private String userBirth;
    private String userName;
    private long userId;
    private int status;
    private String token;
    private String sessionId;


    /**
     * {
     * 	"imgUrl": "https://qauserimgs.jeejio.com/qa/202004031326/userinfo/2020-10-19/be710d73eb324d91928223e02a591310.jpg",
     * 	"userBirth": "2020-06-18",
     * 	"userName": "物栖咯qedghu骨灰盒",
     * 	"userId": "202004031326",
     * 	"status": 1
     * }
     */

}
