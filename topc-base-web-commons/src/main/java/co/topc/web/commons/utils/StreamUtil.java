package co.topc.web.commons.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @author RuntimeExcepti0n
 * @date 2019/7/6 11:15
 */
public final class StreamUtil {
    private StreamUtil() {
    }

    /**
     * 获取集合流，如果为空，返回空流
     *
     * @param collection 入参集合
     * @return boolean
     */
    public static <T> Stream<T> streamOf(Collection<T> collection) {
        return TopcCollectionUtils.isEmpty(collection) ? Stream.empty() : collection.stream();
    }

    /**
     * 获取集合流
     *
     * @param array 入参数组
     * @return stream 流
     */
    public static <T> Stream<T> streamOf(T[] array) {
        return ArrayUtils.isEmpty(array) ? Stream.empty() : Arrays.stream(array);
    }
}
