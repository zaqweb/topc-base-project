package co.topc.web.commons.utils;

import java.util.UUID;

/**
 * @author fantao
 * @date 2019/7/17 8:42
 */
public final class TopcUUIDUtils {

    /**
     * 获取UUID
     *
     * @return 36位ID字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取UUID,不包含'-'
     *
     * @return 32位ID字符串
     */
    public static String getUUIDWithoutDash() {
        return TopcStringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }
}
