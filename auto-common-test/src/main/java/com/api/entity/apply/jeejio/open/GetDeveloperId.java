package com.api.entity.apply.jeejio.open;

import lombok.Data;

@Data
public class GetDeveloperId {
    private String createUser;
    /**
     * {"createUser":"202004031326"}
     *
     * {
     * 	"statusCode": 200,
     * 	"success": 1,
     * 	"resultValue": {
     * 		"createUser": 202004031326,
     * 		"id": 202004036478,
     * 		"devName": "chenlitest003",
     * 		"devType": 1,
     * 		"contactsName": "chenli",
     * 		"currentState": "4",
     * 		"contactsPhone": "15701188230",
     * 		"contactsEmail": "844981671@qq.com",
     * 		"otherContact": "",
     * 		"contactsAddress": "",
     * 		"website": ""
     *        }
     * }
     */
}
