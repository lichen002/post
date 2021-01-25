package com.test.user;

import com.alibaba.fastjson.JSONObject;
import com.api.entity.user.JudgeUserExistOpen;
import com.api.entity.user.SetUserInfoOpen;
import com.api.http.common.ApiPath;
import com.api.http.common.TestData;
import com.api.utils.utils;
import com.imlp.user.info.UserInfoImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.util.stream.Stream;
import static java.lang.Thread.sleep;

@Slf4j
public class UserInfoTest implements TestData, ApiPath {
    static long userId;
    static String userCode;
    String path;
    UserInfoImpl UserInfoImlp = new UserInfoImpl();

    @BeforeClass
    public void setUp() throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        log.info("userInfo is {}",userInfo);
        userCode =(String) userInfo.get("userCode");
        userId =(Long) userInfo.get("id");
        path = this.getClass().getClassLoader().getResource("./prop/text.txt").getPath();


    }

    @Test
    //更改用户信息
    @CsvFileSource(resources = "test/applydata/login/testdata.csv")
    public void testSetUserInfo(String str) throws IOException, InterruptedException {
        SetUserInfoOpen setUserInfoOpen = new SetUserInfoOpen();
        sleep(3000);
        setUserInfoOpen.setUserName("lciehn");
        setUserInfoOpen.setImgUrl("https://qauserimgs.jeejio.com/qa/202004031326/userinfo/2020-10-19/be710d73eb324d91928223e02a591310.jpg");
        setUserInfoOpen.setStatus(2);
        setUserInfoOpen.setUserBirth("2020-06-18");
        setUserInfoOpen.setUserId(userId);
        String result = UserInfoImlp.setUserInfo(setUserInfoOpen);
        log.info("result is {}",result);

        JudgeUserExistOpen judgeUserExistOpen = new JudgeUserExistOpen();
        judgeUserExistOpen.setUserKey(TEST_ACCOUNT);
        judgeUserExistOpen.setStatus("2");
        String resultInfo = UserInfoImlp.judgeUserExist(judgeUserExistOpen);
        log.info("resultInfo is {}",resultInfo);



    }

    @ParameterizedTest
    //更改用户信息
    @CsvFileSource(resources ="/testdata.csv",numLinesToSkip = 1)
    public void testCsv(String str,int age,String zhiye){
        System.out.println(str);
        System.out.println(age);
        System.out.println(zhiye);
    }

    @ParameterizedTest
    @MethodSource("ExcelMethod")
    public void qiucaoTest(String person){
        System.out.println(person);
    }

    public static Stream<Arguments> ExcelMethod() {
        return utils.getTestDataStreamFromExcelFile(".\\auto-http-test\\src\\test\\testdata.csv","Sheet1");
    }


    @ParameterizedTest
    @CsvSource({
            "apple,     1",
            "banana,    2"
    })
    public void testWithCsvSource(String fruit,int rank){
        System.out.println(fruit);
        System.out.println(rank);
    }





    @ParameterizedTest
    @CsvSource({
            "1","2","3"
    })
    void twoSum(int i) {
        System.out.println(i);
    }




}
