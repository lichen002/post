package com.api.entity.apply;

import lombok.Data;

@Data
public class SearchApply {
    private String machineCode;
    private String keyword;
    private String machineTypeV;
    private long userId;


    /**
     * {
     * 	"machineCode": "0127180000180000001d",
     * 	"keyword": "聊天",
     * 	"machineTypeV": "10008",
     * 	"userId": "202004031326"
     * }
     */
}
