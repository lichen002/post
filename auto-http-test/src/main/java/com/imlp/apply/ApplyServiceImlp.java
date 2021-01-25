package com.imlp.apply;

import com.alibaba.fastjson.JSON;
import com.api.entity.apply.*;
import com.api.service.apply.ApplyService;

import java.io.IOException;

import static com.api.http.common.ApiPath.*;
import static com.api.http.common.HttpDelegate.postAndToken;

public class ApplyServiceImlp implements ApplyService {
    @Override
    public String applyInstall(ApplyInstall applyInstall) throws IOException {
        String request = JSON.toJSONString(applyInstall);
        return postAndToken(APPLY_OPEN,request);
    }

    @Override
    public String applyOpen(ApplyOpen applyOpen) throws IOException {
        String request = JSON.toJSONString(applyOpen);
        return postAndToken(DEVICE_APPLY,request);
    }

    @Override
    public String applyUnInstall(ApplyUnInstall applyUnInstall) throws IOException {
        String request = JSON.toJSONString(applyUnInstall);
        return postAndToken(DEVICE_APPLY,request);
    }

    @Override
    public String applyClose(ApplyClose applyClose) throws IOException {
        String request = JSON.toJSONString(applyClose);
        return postAndToken(DEVICE_APPLY,request);
    }

    @Override
    public String applyList(ApplyList applyList) throws IOException{
        String request = JSON.toJSONString(applyList);
        return postAndToken(APPLY_LIST,request);
    }

    @Override
    public String applySearch(SearchApply searchApply) throws IOException {
        String request = JSON.toJSONString(searchApply);
        return postAndToken(SEARCH_APPLY,request);

    }

    @Override
    public String applyUpdate(ApplyUpdate applyUpdate) throws IOException {
        String request = JSON.toJSONString(applyUpdate);
        return postAndToken(UPDATE_APPLY,request);
    }
}
