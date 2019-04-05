package com.dataserver.eshop.serverdataeshop.common.utils;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/4 20:45
 * @Version 1.0
 **/
public class StringUtil {
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
}
