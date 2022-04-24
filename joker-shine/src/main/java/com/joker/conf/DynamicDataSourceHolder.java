package com.joker.conf;

import lombok.extern.slf4j.Slf4j;

/**
 * DynamicDataSourceHolder
 *
 * @author joker
 * @version 1.0
 * 2022/4/22 16:53
 **/
@Slf4j
public class DynamicDataSourceHolder {
    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";

    public static String getDbType() {
        String db = contextHolder.get();
        if (db == null) {
            db = DB_MASTER;
        }
        return db;
    }

    public static void setDBType(String str) {
        log.info("数据源为" + str);
        contextHolder.set(str);
    }

    public static void clearDbType() {
        contextHolder.remove();
    }


}
