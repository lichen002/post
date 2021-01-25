package com.api.http.common;

public interface ApiPath {
   String DVICES_HOST = "https://machine.qajeejio.com/";
   String APPLY_HOST = "https://appmarket.qajeejio.com/";
   String USER_HOST = "https://jeejiouser.qajeejio.com/";


   //贝多盒设备接口地址
   String DEVICES_PATH = "device/machine/v2/";
   String DEVICES_LIST = DVICES_HOST+DEVICES_PATH+"getMachineManageList";
   String DEVICES_INFO = DVICES_HOST+DEVICES_PATH+"getMachineInfo";
   String GET_DEVICES_BUILD_STATUS = DVICES_HOST+DEVICES_PATH+"getDeviceBindStatus";
   String RELATE_MACHINE_AND_USER = "http://10.2.0.1/"+DEVICES_PATH+"relateMachineAndUser";

   //获取设备上面已经安装的应用
   String DEVICES_APPLY = "device/app/v2/";
   String DEVICES_APPLY_INSTALL =DVICES_HOST+DEVICES_APPLY+"listMachineAppInfo";




   //贝多盒应用接口地址
   String APPLY_PATH ="appMarket/soft/";
   String DEVICE_APPLY_PATH = "device/machine/";
   String APPLY_OPEN = APPLY_HOST+APPLY_PATH+"invokingMachineByDm";
   String APPLY_LIST = APPLY_HOST+APPLY_PATH+"listNewAppsByDm";
   String APPLY_INSTALL =APPLY_HOST+APPLY_PATH+ "invokingMachineByDm";
   String DEVICE_APPLY =DVICES_HOST+DEVICE_APPLY_PATH+ "invokingMachine";
   String DEVICES_UNINSTALL_APPLY = "";
   String SEARCH_APPLY =APPLY_HOST+APPLY_PATH+ "getAppSearchResult";
   String UPDATE_APPLY = DVICES_HOST+DEVICE_APPLY_PATH+ "invokingMachine";
   String RECCOMMEND_APP_LIST =APPLY_HOST+APPLY_PATH+ "listRecommendAppsByDm";
   String GET_APP_STATUS =APPLY_HOST+APPLY_PATH+  "getAppStatus";

   //贝多盒用户信息接口
   String USER_PATH = "user/person/";
   String SET_USER_INFO =USER_HOST+USER_PATH+ "changeUserInfoControl";
   String GET_USER_INFO = USER_HOST+"user/users/judgeIsUserExist";
   String USER_REGISTER = USER_HOST +"user/sso/v2/verificationCodePhoneRegist";


   /*
   接口地址
    */
   String SERVICE_DEVICES = "http://10.10.11.98";
   String LOGIN_OUT_SERVICE_PATH = "http://10.10.11.61:8501/user/sso/logoutUser";
   String UNBIND_DEVICES_RESTORE_NETWORK = SERVICE_DEVICES+"/machine/machine/unbindMachine";
   String GET_DEVICES_LIST = SERVICE_DEVICES+"/machine/machine/getMachineManageList";
   String RESET_PASSWORD = SERVICE_DEVICES+"/user/users/setOrChangePassword";
   String REGIST_USER_ACCOUNT = SERVICE_DEVICES + "/user/users/registUser";
   String JUDGE_USER_EXIST =SERVICE_DEVICES+ "/user/users/judgeUserExist";


   /**
    * 开放平台
    */
   //新版本发布接口
   String OPEN_USER_PATH = "https://jeejiowebuser.qajeejio.com/user/sso/";
   String OPEN_SERVICE_PATH = "https://openapp.qajeejio.com/openapp/app/";
   String OPEN_APPLY_NEW_VERSION = OPEN_SERVICE_PATH+"publishVersion";
   String SURE_PUBILSH_VERSION = OPEN_SERVICE_PATH+"surePublishVersion";
   String GET_DEVELOPER_ID = "https://developer.qajeejio.com/aptitude/getAptitudeUserByUserId";
   String SELECT_NEW_PACKAGE_ID = OPEN_SERVICE_PATH+"selectAppNewPackageInfo";
   String LOGIN_PATH = OPEN_USER_PATH+"accountLogin";

   /**
    * 审核平台
    */

   String REVIEW_PASH = "https://admin.qajeejio.com/examineApp/";
   String APPLY_CHANGE_CLAIM =REVIEW_PASH+ "changeClaim";
   String APPLY_CHECK_PASS =REVIEW_PASH+ "approved";
   String APPLY_GET_CHANGE_LIST =REVIEW_PASH+ "userChangeList";
   String APPLY_PRE_RELEASE = REVIEW_PASH+"preRelease";


   //接口地址


}
