package com.venk.daily.book.talkdesignpattern.strategy;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

/**
 * 时间计算抽象类
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-01-04 15:58
 */
@Slf4j
public abstract class BaseTimeCalculator {

    /**
     * 计算毫秒差时间间隔
     *
     * @param firstTime
     * @param lastTime
     * @return
     */
    public abstract Double timestampCalc(Timestamp firstTime, Timestamp lastTime);

    /**
     * 计算自然时间间隔
     *
     * @param firstTime
     * @param lastTime
     * @return
     */
    public abstract Double natureCalc(Timestamp firstTime, Timestamp lastTime);

}
