package com.api.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.entity.apply.ApplyList;
import com.api.entity.apply.ApplyUnInstall;
import com.api.entity.apply.jeejio.open.GetDeveloperId;
import com.api.entity.apply.jeejio.open.PublistVersion;
import com.api.entity.apply.jeejio.open.SelectNewPackageId;
import com.api.entity.apply.jeejio.open.SurePublishVersion;
import com.api.entity.apply.jeejio.review.AppChangeClaim;
import com.api.entity.apply.jeejio.review.AppCheckPass;
import com.api.entity.apply.jeejio.review.AppGetChangeList;
import com.api.entity.apply.jeejio.review.AppPreRelease;
import com.api.entity.devices.GetDevicesInstallApply;
import com.api.entity.login.LoginOpen;
import com.api.http.common.HttpDelegate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.params.provider.Arguments;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static com.api.http.common.ApiPath.*;
import static com.api.http.common.TestData.TEST_ACCOUNT;
import static com.api.http.common.TestData.TEST_PASSWORD;

@Slf4j
public class utils {

    /**
     *  获取登录的用户信息
     * @param userPhone
     * @param password
     * @return
     * @throws IOException
     */
    public static JSONObject getUserInfo(String userPhone,String password) throws IOException {
        LoginOpen loginOpen = new LoginOpen();
        loginOpen.setUserKey(userPhone);
        loginOpen.setUserPasswd(password);
        loginOpen.setPlatform("kf");
        loginOpen.setTool("1");
        String requestString = JSONObject.toJSONString(loginOpen);
        String loginResult = HttpDelegate.post(LOGIN_PATH, requestString);
        JSONObject response = JSON.parseObject(loginResult);
        log.info("response is {}",response);
        JSONObject resultValue =(JSONObject) response.get("resultValue");
        return resultValue;
    }


    public static JSONObject getApplyList(String machineCode,String machineTypeV,long userId,String userCode) throws IOException {
        ApplyList applyList = new ApplyList();
        applyList.setMachineCode(machineCode);
        applyList.setMachineTypeV(machineTypeV);
        applyList.setPageNum(1);
        applyList.setPageSize(20);
        applyList.setUserId(userId);
        applyList.setUserCode(userCode);
        String requestString = JSONObject.toJSONString(applyList);
        String appListResult = HttpDelegate.postAndToken(APPLY_LIST, requestString);
        JSONObject response = JSON.parseObject(appListResult);
        log.info("response is {}",response);
        return response;

    }

    /**
     * 清空设备上面已经安装的应用
     * @return
     */
    public static JSONObject clearDevicesInstallApply(ApplyUnInstall applyUnInstall) throws IOException {
        String request = JSON.toJSONString(applyUnInstall);
        String result = HttpDelegate.postAndToken(DEVICE_APPLY, request);
        JSONObject resultJsonObject = JSON.parseObject(result);
        return resultJsonObject;


    }

    /**
     * //获取设备上已经安装的应用
     * @param getDevicesInstallApply
     * @return
     * @throws IOException
     */
    public static JSONObject getDevicesInstllApply(GetDevicesInstallApply getDevicesInstallApply) throws IOException {

        String request = JSON.toJSONString(getDevicesInstallApply);

        String result = HttpDelegate.postAndToken(DEVICES_APPLY_INSTALL, request);
        log.info("request is {}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        return jsonObject;
    }


    /**
     *
     * @param excelFullPath
     * @param sheetName
     * @return
     */

    public static Stream<Arguments> getTestDataStreamFromExcelFile(String excelFullPath,
                                                                   String sheetName){

        Stream<Arguments> returnStream = Stream.empty();
        //定义单元格数据格式处理对象
        DataFormatter myDataFormatter = new DataFormatter();

        //获取工作簿对象
        try(Workbook excelFile = WorkbookFactory.create(new File(excelFullPath),null,true)) {
            //获取工作表
            Sheet excelSheet1 = excelFile.getSheet(sheetName);
            //行数据处理，忽略标题行，行数据作为后续参数List
            for(Row row: excelSheet1){
                if(row.getRowNum()==0) {continue;}
                ArrayList<Object> rowArrayList = new ArrayList<>();
                //获取单元格数值，存入行List
                for (Cell cell : row) {
                    rowArrayList.add(myDataFormatter.formatCellValue(cell));
                }
                //转换为MethodSource的Arguments对象
                Arguments arguments = Arguments.of(rowArrayList.toArray());
                //Arguments转换为Stream
                returnStream = Stream.concat(returnStream,Stream.of(arguments));
            }
            return returnStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnStream;
    }


    public static void applyReleaseNewVersion(int isForce) throws IOException, InterruptedException {
        //登录获取用户id
        JSONObject userInfo = getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        long longId1=(long)userInfo.get("id");
        String strId = String.valueOf(longId1);

        //通过用户id获取开发者id
        GetDeveloperId getDeveloperId = new GetDeveloperId();
        getDeveloperId.setCreateUser(strId);
        String getDeveloperIdString = JSON.toJSONString(getDeveloperId);
        String strDeveloperId = HttpDelegate.postAndToken(GET_DEVELOPER_ID, getDeveloperIdString);
        JSONObject jsonObject = JSON.parseObject(strDeveloperId);
        JSONObject resultValue1 =(JSONObject) jsonObject.get("resultValue");
        long id =(long) resultValue1.get("id");

        //发布新版本
        Thread.sleep(1000);
        PublistVersion publistVersion = new PublistVersion();
        Random random = new Random();
        long longId = Long.parseLong(strId);
        publistVersion.setDeveloperId(id);
        publistVersion.setAppId(2020081840666l);
        publistVersion.setCreateUser(longId);
        publistVersion.setInstallSize(1598454);
        publistVersion.setIsContainWeb(0);
        publistVersion.setIsForce(isForce);
        publistVersion.setIsQuoteJmSdk(0);
        publistVersion.setIsQuoteJosSdk(0);
        publistVersion.setPackageId(20201126305832l);
        publistVersion.setUpdateContent(315);
        publistVersion.setVersion(String.valueOf(random.nextInt(100000)));
        publistVersion.setResourceId(20201126305764l);
        String  strPublistVersion = JSON.toJSONString(publistVersion);
        HttpDelegate.postAndToken(OPEN_APPLY_NEW_VERSION,strPublistVersion);

        //获取app审核变更列表
        Thread.sleep(3000);
        AppGetChangeList appGetChangeList = new AppGetChangeList();
        appGetChangeList.setCreateUser(longId);
        String strAppGetChangeList = JSON.toJSONString(appGetChangeList);
        String s =HttpDelegate.postAndToken(APPLY_GET_CHANGE_LIST, strAppGetChangeList);
        JSONObject jsonObject1 = JSON.parseObject(s);
        JSONObject resultValue2 =(JSONObject) jsonObject1.get("resultValue");
        JSONArray list =(JSONArray) resultValue2.get("list");
        JSONObject lastList =(JSONObject) list.get(0);
        long id1 =(long) lastList.get("id");
        log.info("id1 is {}",id1);

        //领取这个需要发布的应用
        Thread.sleep(1000);
        AppChangeClaim appChangeClaim = new AppChangeClaim();
        appChangeClaim.setAppId(2020081840666l);
        appChangeClaim.setCreateUser(longId);
        appChangeClaim.setQualiReviewId(id1);
        appChangeClaim.setOperatorName("易烊千玺");
        String strAppChangeClaim = JSONObject.toJSONString(appChangeClaim);
        String claimResult = HttpDelegate.postAndToken(APPLY_CHANGE_CLAIM, strAppChangeClaim);
        log.info("claimResult is {}",claimResult);

        //预发布这个应用
        Thread.sleep(1000);
        AppPreRelease appPreRelease = new AppPreRelease();
        appPreRelease.setAppId(2020081840666l);
        appPreRelease.setCreateUser(longId);
        appPreRelease.setOperatorName("易烊千玺");
        appPreRelease.setQualiReviewId(id1);
        String strAppPreRelease = JSON.toJSONString(appPreRelease);
        HttpDelegate.postAndToken(APPLY_PRE_RELEASE, strAppPreRelease);

        //审核通过这个应用发布
        Thread.sleep(1000);

        AppCheckPass appCheckPass = new AppCheckPass();
        appCheckPass.setAppId(2020081840666l);
        appCheckPass.setAppLevel(3);
        appCheckPass.setOperatorName("易烊千玺");
        appCheckPass.setCreateUser(longId);
        appCheckPass.setQualiReviewId(id1);
        appCheckPass.setVerifyDesc(123);
        String strAppCheckPass = JSON.toJSONString(appCheckPass);
        log.info("strAppCheckPass is {}",strAppCheckPass);
        String shenheNewVersionResult = HttpDelegate.postAndToken(APPLY_CHECK_PASS, strAppCheckPass);

        //获取最新包的id
        Thread.sleep(1000);

        SelectNewPackageId selectNewPackageId = new SelectNewPackageId();
        selectNewPackageId.setCreateUser(longId);
        selectNewPackageId.setDeveloperId(id);
        selectNewPackageId.setId(2020081840666l);
        String strSelectNewPackageId = JSON.toJSONString(selectNewPackageId);
        String s1 = HttpDelegate.postAndToken(SELECT_NEW_PACKAGE_ID, strSelectNewPackageId);
        JSONObject jsonObject2 = JSON.parseObject(s1);
        JSONObject resultValue =(JSONObject) jsonObject2.get("resultValue");
        long packageId =(long) resultValue.get("packageId");


        //开放平台确认发布这个应用
        Thread.sleep(1000);

        SurePublishVersion surePublishVersion = new SurePublishVersion();
        surePublishVersion.setAppId(2020081840666l);
        surePublishVersion.setCreateUser(longId);
        surePublishVersion.setPackageId(packageId);
        String strSurePublishVersion = JSON.toJSONString(surePublishVersion);
        String newVersionResult = HttpDelegate.postAndToken(SURE_PUBILSH_VERSION, strSurePublishVersion);
        log.info("newVersionResult is {}",newVersionResult);



    }


    /**
     * 执行adb命令
     * @param cmd adb命令
     * @throws IOException
     */
    public static void appCmd(String cmd) throws IOException {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = null;
        BufferedReader ie = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String error = null;

        while ((error = ie.readLine()) != null
                && !error.equals("null")) {
            data += error + "\n";
        }

        String line = null;
        while ((line = in.readLine()) != null
                && !line.equals("null")) {
            data += line + "\n";
        }

    }


    /**
     * 数据库连接
     */
     public static ResultSet connSql(String sql,String url,String user,String password) throws SQLException {
         Connection c = null;
         Statement stmt = null;

         try {
             Class.forName("org.postgresql.Driver");
             c = DriverManager.getConnection(url, user, password);
//                     .getConnection("jdbc:postgresql://10.10.11.120:5432/jeejio_device_center",
//                             "qa_device", "a033c8bc87ffeed1af8a9a64c6beb4b5");
         } catch (Exception e) {
             e.printStackTrace();
             System.err.println(e.getClass().getName()+": "+e.getMessage());
             System.exit(0);
         }
         System.out.println("Opened database successfully");
         stmt = c.createStatement();
         ResultSet resultSet = stmt.executeQuery(sql);
         stmt.close();
         c.close();
         return resultSet;

     }


    /**
     * 读取相对路径文件
     */
    public static List<String> readFileByLine(String file) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        InputStream inputStream = utils.class.getClassLoader().getResourceAsStream(file);
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bf = new BufferedReader(inputReader);
        // 按行读取字符串
        String str;
        while ((str = bf.readLine()) != null) {
            arrayList.add(str);
        }
        bf.close();
        inputReader.close();
        return arrayList;
    }





}
