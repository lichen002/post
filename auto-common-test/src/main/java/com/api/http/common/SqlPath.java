package com.api.http.common;

public interface SqlPath {
    /**
     * 设备连接表数据
     */
    String SQL_HOST = "jdbc:postgresql://10.10.11.120:5432/";
    String DEVICE_CENTER_URL =SQL_HOST+ "jeejio_device_center";
    String DEVICE_CENTER_USER = "qa_device";
    String DEVICE_CENTER_PASSWORD = "a033c8bc87ffeed1af8a9a64c6beb4b5";
}
