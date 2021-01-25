package com.api.http.common;

import com.alibaba.fastjson.JSONObject;
import com.api.utils.utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class HttpDelegate extends utils implements TestData{
    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static String post(String path,String json) throws IOException {
        HttpPost httpPost = new HttpPost(path);
        //json形式
        httpPost.addHeader("content-type", "application/json;charset=utf-8");
        httpPost.addHeader("accept","application/json");
        httpPost.setEntity(new StringEntity(json, Charset.forName("utf-8")));
        return execute(httpPost);
    }

    public static String postAndToken(String path,String json) throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        HttpPost httpPost = new HttpPost(path);
        String token =(String) userInfo.get("token");
        String sessionId =(String) userInfo.get("sessionId");
        httpPost.addHeader("token",token);
        httpPost.addHeader("sessionId",sessionId);
        httpPost.addHeader("content-type", "application/json;charset=utf-8");

        httpPost.setEntity(new StringEntity(json, Charset.forName("utf-8")));
        return execute(httpPost);
    }
    /**
     *
     * @param path
     * @param params
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public String post(String path, List<NameValuePair> params) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(path).addParameters(params).build();
        HttpPost httpPost = new HttpPost(uri);
        //  httpPost.setHeader("Accept-Encoding", "gzip,deflate");//表示返回的数据是压缩的zip格式
        //加不加？？
//        httpPost.addHeader("content-type", "application/json;charset=utf-8");
//        httpPost.addHeader("accept","application/json");
        httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        return execute(httpPost);
    }

    /**
     *
     * @param path
     * @param params
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public String post(String path, List<String> pathVariables, List<NameValuePair> params) throws IOException, URISyntaxException {
        String pathVariablesString = StringUtils.join(pathVariables.toArray(), "/");
        URI uri = new URIBuilder(path+"/"+pathVariablesString).addParameters(params).build();
        HttpPost httpPost = new HttpPost(uri);
        //  httpPost.setHeader("Accept-Encoding", "gzip,deflate");//表示返回的数据是压缩的zip格式
        //加不加？？
        httpPost.addHeader("content-type", "application/json;charset=utf-8");
        httpPost.addHeader("accept","application/json");
        httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        return execute(httpPost);
    }

    /**
     *
     * @param path
     * @param params
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public String post(String path, String param, List<NameValuePair> params) throws IOException, URISyntaxException {
        int left = path.indexOf("{");
        String post = path.substring(0,left)+param;
        URI uri = new URIBuilder(post).addParameters(params).build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("content-type", "application/json;charset=utf-8");
        httpPost.addHeader("accept","application/json");
        httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        return execute(httpPost);
    }


    /**
     *
     * @param path
     * @param params
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public  String get(String path, List<NameValuePair> params) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(path).addParameters(params).build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("accept","application/json");
        return execute(httpGet);
    }

    public  String get(String path, String param) throws IOException, URISyntaxException {
        int left = path.indexOf("{");
        String get = path.substring(0,left)+param;//{jobId}"
        URI uri = new URIBuilder(get).build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("accept","application/json");
        return execute(httpGet);
    }

    private  static String execute(HttpRequestBase httpRequestBase) throws IOException {
        //json形式
        CloseableHttpResponse response = httpclient.execute(httpRequestBase);
        try {
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            String string = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            EntityUtils.consume(entity);
            return string;
        } finally {
            response.close();
        }
    }
}
