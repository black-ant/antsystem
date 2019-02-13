package com.serverdata.order.serverdataorder.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 22:39
 * @Version 1.0
 **/
public class CommonUtils {
    /**
     * 向一个String 在指定方向上 添加 指定字符串 , 到指定的长度
     *
     * @param srcStr {String}-原本的字符串
     * @param srcChar {String}-指定要加的字符串
     * @param destLen {String}-指定的长度
     * @param location {int}-指定方向 0为在前加,1为在后加
     * @return double
     */
    public static String addChartoString(String srcStr, String srcChar, int destLen, int location) {
        int srcLen = srcStr.length();//获得字符串长度
        if (srcLen >= destLen || destLen == 0) {//长度大于所求或所求长度为0，即返回原值
            return srcStr;
        }
        for (int i = 0; i < destLen - srcLen; i++) {
            if (location == 0) { //在前面加
                srcStr = srcChar.concat(srcStr);
            } else //if(location == 1){ //在后面加
            {
                srcStr = srcStr.concat(srcChar);
            }
        }
        return srcStr;
    }

    /**
     * 获得无分号时间YYMMDDHHmmSS
     *
     * @return String：YYMMDDHHmmSS
     */
    public static String getStringYYMMDDHHmmSS() {//取时间
        java.util.Date Date = new java.util.Date();
        DateFormat FormatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftDate = FormatDate.format(Date);
        //String ID = ftDate.substring(0, 4) + ftDate.substring(5, 7) + ftDate.substring(8, 10) + ftDate.substring(11, 13) + ftDate.substring(14, 16) + ftDate.substring(17, 19);
        String ID1 = ftDate.substring(2, 4) + ftDate.substring(5, 7) + ftDate.substring(8, 10) + ftDate.substring(11, 13) + ftDate.substring(14, 16) + ftDate.substring(17, 19);
        return ID1;
    }

    /**
     * 编辑ID序号
     *
     * @param orderno{String}-ID值
     * @param type{String}-前缀
     * @param number{int}-添加方式（改前缀/全改）
     * @return double
     */
    public static String getnextOrder(String orderno, String type, int number) {
        if (number == 0) {
            return type + orderno.substring(1);
        } else if (number > 0) {
            DateFormat FormatDate = new SimpleDateFormat("yyMMdd");
            String yyddmm = FormatDate.format(new Date());
            return type + yyddmm + addChartoString(orderno, "0", 6, 0);
        } else {
            return orderno;
        }

    }
}
