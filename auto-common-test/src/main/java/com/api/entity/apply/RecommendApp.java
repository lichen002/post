package com.api.entity.apply;

import lombok.Data;

/**
 * 精品推荐app
 */
@Data
public class RecommendApp {
    private String machineCode;
    private String userId;
    private String userCode;
    private int machineTypeV;

    /**
     * {
     * 	"machineCode": "0127180000180000001d",
     * 	"userId": "202004031326",
     * 	"userCode": "jeejio_11488",
     * 	"machineTypeV": 10008
     * }
     */
}
