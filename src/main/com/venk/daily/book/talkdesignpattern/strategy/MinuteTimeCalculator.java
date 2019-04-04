package com.venk.daily.book.talkdesignpattern.strategy;

import com.venk.daily.util.DateUtil;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 分钟计算
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-01-04 15:59
 */
@Component
public class MinuteTimeCalculator extends BaseTimeCalculator {

    @Override
    public Double timestampCalc(Timestamp firstTime, Timestamp lastTime) {
        Long result = firstTime.getTime() - lastTime.getTime();
        return Math.abs(result.doubleValue()) / DateUtil.MINUTE;
    }

    @Override
    public Double natureCalc(Timestamp firstTime, Timestamp lastTime) {
        return ((Long) DateUtil.getNumberOfMinutesBetween(firstTime, lastTime)).doubleValue();
    }

}
