package co.topc.web.commons.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Topc字符串工具类
 *
 * @author zaqweb
 * @date 2019-06-30 15:46
 */
public final class TopcStringUtils extends StringUtils {

    /**
     * @param value 校验值
     * @return 校验值为null或""返回true，否则返回false
     */
    public static boolean isEmpty(String value) {
        return StringUtils.isEmpty(value);
    }

    /**
     * @param value 校验值
     * @return 校验值不为null且不为""返回true，否则返回false
     */
    public static boolean isNotEmpty(String value) {
        return !StringUtils.isEmpty(value);
    }
}
