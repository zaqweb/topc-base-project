package co.topc.web.commons.utils;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author RuntimeExcepti0n
 * @date  2019/7/6 11:15
 */
public class TopcCollectionUtils {
    /**
     * 校验Collection集合，null或者空返回true,否则返回false
     * @param coll 入参Collection
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> coll){
        return CollectionUtils.isEmpty(coll);
    }

    /**
     * 校验Map集合，为null 或者空返回true,否则返回false
     * @param map 入参Map
     * @return boolean
     */
    public static boolean isEmpty(Map map){
        return CollectionUtils.isEmpty(map);
    }

    /**
     * 校验Collection集合，null或者空返回false,否则返回true
     * @param coll 入参集合
     * @return boolean
     */
    public static boolean isNotEmpty(Collection<?> coll){
        return !CollectionUtils.isEmpty(coll);
    }

    /**
     * 校验Map集合，为null 或者空返回false,true
     * @param map  入参Map
     * @return  boolean
     */
    public static boolean isNotEmpty(Map map){
        return !CollectionUtils.isEmpty(map);
    }

}
