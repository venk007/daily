package com.venk.daily.book.talkdesignpattern.strategy;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Map;

/**
 * 时间颗粒度
 *
 * @author Venk[liwenkeq@sina.com]
 */
@Getter
@AllArgsConstructor
public enum TimeGranularityEnum {

    /**
     * 分钟
     */
    MINUTE("minute", "%Y%m%d%H%i", "yyyyMMddHHmm", "%Y-%m-%d %H:%i:00"),
    /**
     * 小时
     */
    HOUR("hour", "%Y%m%d%H", "yyyyMMddHH", "%Y-%m-%d %H:00:00"),
    /**
     * 天
     */
    DAY("day", "%Y%m%d", "yyyyMMdd", "%Y-%m-%d 00:00:00"),
    /**
     * 月
     */
    MONTH("month", "%Y%m", "yyyyMM", "%Y-%m-00 00:00:00"),
    ;

    /**
     * 颗粒度值
     */
    private String code;
    /**
     * 数据库格式
     */
    private String dataBaseFormat;
    /**
     * 代码格式
     */
    private String codeFormat;
    /**
     * 自然月/时/天/月格式
     */
    private String naturalFormat;

    private static final Map<String, TimeGranularityEnum> LOOKUP = Maps.newHashMapWithExpectedSize(4);

    static {
        for (TimeGranularityEnum timeGranularityEnum : EnumSet.allOf(TimeGranularityEnum.class)) {
            LOOKUP.put(timeGranularityEnum.getCode(), timeGranularityEnum);
        }
    }

    public static TimeGranularityEnum getByCode(String code) {
        TimeGranularityEnum timeGranularityEnum = LOOKUP.get(code);
        return timeGranularityEnum;
    }

}
