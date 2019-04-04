package com.venk.daily.book.talkdesignpattern.strategy;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.venk.daily.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/**
 * 时间计算-抽象方法工厂
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-01-04 16:35
 */
@Slf4j
@Component
public class TimeCalculatorFactory implements CommandLineRunner {

    @Resource
    SpringContextUtil springContextUtil;

    public static final Map<TimeGranularityEnum, BaseTimeCalculator> LOOKUP = Maps.newEnumMap(TimeGranularityEnum.class);

    /**
     * SpringBoot 启动自动注入
     *
     * @param strings
     */
    @Override
    public void run(String... strings) {
        List<BaseTimeCalculator> timeCalculators = new ArrayList();
        timeCalculators.addAll(springContextUtil.getApplicationContext().getBeansOfType(BaseTimeCalculator.class).values());
        EnumSet.allOf(TimeGranularityEnum.class).forEach(timeGranularityEnum -> {
            for (BaseTimeCalculator timeCalculator : timeCalculators) {
                if (timeCalculator.getClass().getName().toUpperCase().contains(timeGranularityEnum.name())) {
                    LOOKUP.put(timeGranularityEnum, timeCalculator);
                    break;
                }
            }
        });
    }

    /**
     * 自测手动注入
     */
    public static void init() {
        LOOKUP.put(TimeGranularityEnum.MINUTE, new MinuteTimeCalculator());
        LOOKUP.put(TimeGranularityEnum.HOUR, new HourTimeCalculator());
        LOOKUP.put(TimeGranularityEnum.DAY, new DayTimeCalculator());
        LOOKUP.put(TimeGranularityEnum.MONTH, new MonthTimeCalculator());
    }

    /**
     * 获取时间计算类
     *
     * @param timeGranularityEnum
     * @return
     */
    public static BaseTimeCalculator getTimeCalculator(TimeGranularityEnum timeGranularityEnum) {
        Preconditions.checkNotNull(timeGranularityEnum);
        return LOOKUP.get(timeGranularityEnum);
    }

}
