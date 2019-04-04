package com.venk.daily.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateUtil {

    public static final long SECOND = 1000;

    public static final long MINUTE = SECOND * 60;

    public static final long HOUR = MINUTE * 60;

    public static final long DAY = HOUR * 24;

    public static final String DEFAULT_PATTERN = "yyyyMMdd";

    public static final String DEFAULT_PATTERN_WITH_HYPHEN = "yyyy-MM-dd";

    public static final String DATE_TIME_SHORT = "yyyy-MM-dd HH:mm:ss";

    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取当年第一天
     */
    public static Timestamp getFirstDayOfYear() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_YEAR, 1);
        return new Timestamp(c.getTimeInMillis());
    }

    /**
     * 计算2个日期相差的分钟数
     */
    public static long getNumberOfMinutesBetween(Calendar cal1, Calendar cal2) {
        cal1.clear(Calendar.MILLISECOND);
        cal1.clear(Calendar.SECOND);
        cal2.clear(Calendar.MILLISECOND);
        cal2.clear(Calendar.SECOND);
        long elapsed = cal2.getTime().getTime() - cal1.getTime().getTime();
        return Math.abs(elapsed / MINUTE);
    }

    /**
     * 计算2个时间的相隔分钟数
     */
    public static long getNumberOfMinutesBetween(Timestamp before, Timestamp end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(before.getTime());
        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis(end.getTime());
        return getNumberOfMinutesBetween(cal1, cal2);
    }

    /**
     * 计算2个日期相差的小时数
     */
    public static long getNumberOfHoursBetween(Calendar cal1, Calendar cal2) {
        cal1.clear(Calendar.MILLISECOND);
        cal1.clear(Calendar.SECOND);
        cal1.clear(Calendar.MINUTE);
        cal2.clear(Calendar.MILLISECOND);
        cal2.clear(Calendar.SECOND);
        cal2.clear(Calendar.MINUTE);
        long elapsed = cal2.getTime().getTime() - cal1.getTime().getTime();
        return Math.abs(elapsed / HOUR);
    }

    /**
     * 计算2个时间的相隔小时数
     */
    public static long getNumberOfHoursBetween(Timestamp before, Timestamp end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(before.getTime());
        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis(end.getTime());
        return getNumberOfHoursBetween(cal1, cal2);
    }

    /**
     * 计算2个日期直接相差的天数
     */
    public static long getNumberOfDaysBetween(Calendar cal1, Calendar cal2) {
        cal1.clear(Calendar.MILLISECOND);
        cal1.clear(Calendar.SECOND);
        cal1.clear(Calendar.MINUTE);
        cal1.clear(Calendar.HOUR_OF_DAY);
        cal2.clear(Calendar.MILLISECOND);
        cal2.clear(Calendar.SECOND);
        cal2.clear(Calendar.MINUTE);
        cal2.clear(Calendar.HOUR_OF_DAY);
        long elapsed = cal2.getTime().getTime() - cal1.getTime().getTime();
        return Math.abs(elapsed / DAY);
    }

    /**
     * 计算2个时间的相隔天数
     */
    public static long getNumberOfDaysBetween(Timestamp before, Timestamp end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(before.getTime());
        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis(end.getTime());
        return getNumberOfDaysBetween(cal1, cal2);
    }

    /**
     * 返回两个时间间隔的月数
     */
    public static long getNumberOfMonthsBetweenDates(final Timestamp before, final Timestamp end) {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(before.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(end.getTime());
        return Math.abs(Math.abs((c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12) + (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH)));
    }

}
