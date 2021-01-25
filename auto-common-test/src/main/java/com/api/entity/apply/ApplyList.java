package com.api.entity.apply;

import lombok.Data;

@Data
public class ApplyList {
    private String machineCode;
    private int pageSize;
    private String machineTypeV;
    private int pageNum;
    private long userId;
    private String userCode;

/**
 * {
 * 	"machineCode": "0127180000180000001d",
 * 	"pageSize": 10,
 * 	"machineTypeV": "10008",
 * 	"pageNum": 1,
 * 	"userId": "202004031326",
 * 	"userCode": "jeejio_11488"
 * }
 */

}
