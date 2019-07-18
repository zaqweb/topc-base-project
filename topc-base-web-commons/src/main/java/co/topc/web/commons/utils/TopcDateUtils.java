package co.topc.web.commons.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Topc 日期工具类
 *
 * @author zaqweb
 * @date 2019-06-30 15:46
 */
public final class TopcDateUtils extends DateUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";
    public static final String DATE_SHORT_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_CH_FORMAT = "yyyy年MM月dd日";

    public static final String DATE_MONTH_FORMAT = "yyyy-MM";
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_CH_FORMAT = "yyyy年MM月dd日 HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

    public static final String DAYTIME_START = "00:00:00";
    public static final String DAYTIME_END = "23:59:59";


    private static final String[] FORMATS = {"yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss.S", "yyyy/MM/dd HH:mm:ss", "yyyy年MM月dd日 HH:mm:ss",
            "yyyy-MM-dd", "yyyy/MM/dd", "yyyyMMdd", "yyyy年MM月dd日",
            "HH:mm", "HH:mm:ss", "yyyy-MM"};

    /**
     * 日期转成指定格式的日期字符串
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串转成指定格式的日期字符串
     *
     * @param dateStr 字符串
     * @param pattern 日期格式
     * @return
     * @throws ParseException
     */
    public static String dateToString(String dateStr, String pattern) throws ParseException {
        Date date = stringToDate(dateStr);
        return dateToString(date, pattern);
    }

    /**
     * 字符串转成date
     *
     * @param dateStr 字符串
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateStr) throws ParseException {
        return parseDate(dateStr, FORMATS);
    }

    /**
     * 时间毫秒值转成date
     *
     * @param timeMillis 时间毫秒值
     * @return
     */
    public static Date timeMillisToDate(Long timeMillis) {
        return new Date(timeMillis);
    }

    public static String formatFullTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_PATTERN);
    }

    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    private static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        return simformat.format(date);
    }

    public static String formatCSTTime(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date d = sdf.parse(date);
        return getDateFormat(d, format);
    }

    public static void main(String[] args) {
        TopcStringUtils.isEmpty("");
    }
}
