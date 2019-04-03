package com.venk.daily.book.talkdesignpattern.factory;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Map;

/**
 * Description:
 *
 * @Author: venk[liwenke007@gmail.com]
 * @Date: 2019-04-02 18:38
 */
@Getter
@AllArgsConstructor
public enum AlgorithmType {

    /**
     * 运算符枚举
     */
    ADD("+"),

    SUBTRACT("-"),

    MULTIPLY("*"),

    DIVIDE("/"),
    ;

    private String code;

    private static final Map<String, AlgorithmType> LOOKUP = Maps.newHashMapWithExpectedSize(4);

    static {
        for (AlgorithmType algorithmType : EnumSet.allOf(AlgorithmType.class)) {
            LOOKUP.put(algorithmType.getCode(), algorithmType);
        }
    }

    public static AlgorithmType getByCode(String code) {
        return LOOKUP.get(code);
    }

}