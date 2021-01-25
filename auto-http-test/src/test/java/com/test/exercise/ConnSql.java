package com.test.exercise;

import com.api.utils.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.api.http.common.SqlPath.*;

public class ConnSql {
    static String machine_code;
    public static void main(String[] args) throws SQLException {
        String sql = "select*from rel_binding_machine_user where machine_code = '0127180000180000001d'";
        String url = DEVICE_CENTER_URL;
        String user = DEVICE_CENTER_USER;
        String password = DEVICE_CENTER_PASSWORD;
        ResultSet rs = utils.connSql(sql,url,user,password);

        while(rs.next()){
            machine_code = rs.getString("user_code");

        }
        System.out.println(machine_code);
    }
}
