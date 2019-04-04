package com.venk.daily.book.talkdesignpattern.strategy;

import com.venk.daily.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

/**
 * 策略模式
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-04-04 17:18
 */
@Slf4j
public class App {

    private static void calc(Timestamp now, Timestamp firstDayOfYear, TimeGranularityEnum month, String timeSign) {
        BaseTimeCalculator timeCalculator;
        Double result;
        timeCalculator = TimeCalculatorFactory.getTimeCalculator(month);
        result = timeCalculator.natureCalc(now, firstDayOfYear);
        log.info("nature:{}{}", result, timeSign);
        result = timeCalculator.timestampCalc(now, firstDayOfYear);
        log.info("timestamp:{}{}", result, timeSign);
    }

    public static void main(String[] args) {
        Timestamp now = DateUtil.now();
        Timestamp firstDayOfYear = DateUtil.getFirstDayOfYear();
        TimeCalculatorFactory.init();
        calc(now, firstDayOfYear, TimeGranularityEnum.MONTH, "月");
        calc(now, firstDayOfYear, TimeGranularityEnum.DAY, "天");
        calc(now, firstDayOfYear, TimeGranularityEnum.HOUR, "小时");
        calc(now, firstDayOfYear, TimeGranularityEnum.MINUTE, "分钟");
    }

}
