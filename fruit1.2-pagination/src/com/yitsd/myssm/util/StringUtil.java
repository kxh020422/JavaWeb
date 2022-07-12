package com.yitsd.myssm.util;


/**
 * @ClassName StringUtil
 * @Date 2022/6/26 13:49
 */
public class StringUtil {

    /**
     * 功能描述: 判断字符串是否为空或null
     *
     * @param: [str]
     * @return: boolean
     * @auther: co
     * @date: 2022/6/26 14:16
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


}
