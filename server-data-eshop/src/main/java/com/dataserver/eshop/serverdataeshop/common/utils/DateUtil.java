package com.dataserver.eshop.serverdataeshop.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/4 20:45
 * @Version 1.0
 **/
public class DateUtil {



    /**
     * 获得无分号时间YYMMDD
     *
     * @return String：yymmdd
     */
    public static String getStringYYMMDD() {//取得20100303
        java.util.Date Date = new java.util.Date();
        DateFormat FormatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftDate = FormatDate.format(Date);
        //String ID = ftDate.substring(0, 4) + ftDate.substring(5, 7) + ftDate.substring(8, 10) + ftDate.substring(11, 13) + ftDate.substring(14, 16) + ftDate.substring(17, 19);
        String ID1 = ftDate.substring(2, 4) + ftDate.substring(5, 7) + ftDate.substring(8, 10);
        return ID1;
    }

    /**
     * 获得无分号时间YYMMDD
     *
     * @return String：yymmdd
     */
    public static String getStringYYMMDDByDate(Date Date) {//取得20100303
        DateFormat FormatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftDate = FormatDate.format(Date);
        //String ID = ftDate.substring(0, 4) + ftDate.substring(5, 7) + ftDate.substring(8, 10) + ftDate.substring(11, 13) + ftDate.substring(14, 16) + ftDate.substring(17, 19);
        String ID1 = ftDate.substring(2, 4) + ftDate.substring(5, 7) + ftDate.substring(8, 10);
        return ID1;
    }
}
