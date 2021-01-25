package com.api.http.common;

public interface
TestData {
    String TEST_ACCOUNT = "21487";
    String TEST_PASSWORD = "1111qqqq";
    String IMAGE_SUPER_CODE = "6666";
    String PHONE_SUPER_CODE = "888888";
    String TEST_EMAIL_ACCOUNT = "18201422725@163.com";
    String TEST_EMAIL_ACCOUNT2 = "844981671@qq.com";
    String TEST_MACHINE_CODE = "0127180000180000001d";

    //识别字符
    Integer TEST_PASS_SUCCESS = 1;//接口调用成功success
    Integer TEST_PASS_CODE = 200;//接口调用成功code
    Integer TEST_ERROR_SUCCESS = 0;//接口调用失败
    Integer APPLY_SOURCE = 1;//app来源市场
    Integer APPLY_THEMEID = 0;
    Integer APPLY_EVENTTYPE_INSTALL = 1;//安装应用
    Integer APPLY_EVENTTYPE_UNINSTALL = 2;//卸载应用
    Integer APPLY_EVENTTYPE_OPEN = 4; //启动应用
    Integer APPLY_EVENTTYPE_CLOSE = 5; //关闭应用
    Integer APPLY_UNINSTALL_STATUS = 1;//应用未安装
    Integer APPLY_INSTALL_STATUS = 3;//应用已安装
    Integer APPLY_UPDATE_STATUS = 2;//应用可更新

    /**
     * 设备详情页应用状态：
     * 1 启动中 2 卸载中 3 更新中 4 启动中 5 关闭中  0未运行  6运行
     *
     * 应用市场应用状态：
     * 4 下载中  6 失败
     */
}
