package com.dataserver.eshop.serverdataeshop.config;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 17:25
 * @Version 1.0
 **/
public class MySQLConfig extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
