package com.test.apply;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.entity.apply.ApplyList;
import com.api.entity.apply.SearchApply;
import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.api.utils.utils;
import com.imlp.apply.ApplyServiceImlp;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

@Slf4j
public class ApplyListTest implements TestData, ApiPath {
    static long userId;
    static String userCode;
    ApplyServiceImlp applyServiceImlp = new ApplyServiceImlp();


    @BeforeClass
    public  static void setUp() throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        log.info("userInfo is {}",userInfo);
        userCode =(String) userInfo.get("userCode");
        userId =(Long) userInfo.get("id");
    }

    /**
     * 搜索一个已经下架的应用搜索不到
     * @throws IOException
     */
    @Test
    public void testApplyListInfo() throws IOException {
        ApplyList applyList = new ApplyList();
        applyList.setUserCode(userCode);
        applyList.setPageSize(30);
        applyList.setPageNum(1);
        applyList.setMachineTypeV("10008");
        applyList.setMachineCode(TEST_MACHINE_CODE);
        applyList.setUserId(userId);
        log.info("applyList is {}",applyList.toString());
        String result = applyServiceImlp.applyList(applyList);
        JSONObject jsonObject = JSON.parseObject(result);
        log.info("jsonObject is {}",jsonObject);

    }

    /**
     * 搜索一个已经下架的应用搜索不到
     * @throws IOException
     */
    @Test
    public void testApplyLose() throws IOException {
        SearchApply searchApply = new SearchApply();
        searchApply.setKeyword("聊天测试2");
        searchApply.setMachineCode(TEST_MACHINE_CODE);
        searchApply.setMachineTypeV("10008");
        searchApply.setUserId(userId);
        String result = applyServiceImlp.applySearch(searchApply);
        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray resultList =(JSONArray) jsonObject.get("resultList");
        log.info("resultList is {}",resultList.size());
        Assert.assertEquals(0,resultList.size());

    }

    /**
     * 搜索一个已经上架的应用可以搜索到
     * @throws IOException
     */
    @Test
    public void testApplyValid() throws IOException {
        SearchApply searchApply = new SearchApply();
        searchApply.setKeyword("消息推送");
        searchApply.setMachineCode(TEST_MACHINE_CODE);
        searchApply.setMachineTypeV("10008");
        searchApply.setUserId(userId);
        String result = applyServiceImlp.applySearch(searchApply);
        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray resultList =(JSONArray) jsonObject.get("resultList");
        log.info("resultList is {}",resultList.size());
        Assert.assertEquals(1,resultList.size());
    }


}
