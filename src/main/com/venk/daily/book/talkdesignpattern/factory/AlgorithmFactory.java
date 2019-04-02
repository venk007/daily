package com.venk.daily.book.talkdesignpattern.factory;

import java.util.Objects;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description:简单工厂模式-Factory
 * @author:Venk[liwenkeq@sina.com]
 * @date:2018/4/21 00:09
 * @version:V1.0
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public class AlgorithmFactory {

    public static Algorithm getAlgorithm(String symbol) {
        AlgorithmType algorithmType = AlgorithmType.getByCode(symbol);
        switch (algorithmType) {
            case ADD:
                return new com.venk.daily.book.talkdesignpattern.factory.Add();
            case SUBTRACT:
                return new com.venk.daily.book.talkdesignpattern.factory.Subtract();
            case MULTIPLY:
                return new com.venk.daily.book.talkdesignpattern.factory.Multiply();
            case DIVIDE:
                return new Divide();
            default:
                throw new IllegalArgumentException("运算符输入错误");
        }
    }

    public static void main(String[] args) {

        double numberA = 4d;
        double numberB = 2d;
        String symbol = "+";

        Algorithm algo = getAlgorithm(symbol);
        if (Objects.isNull(algo)) {
            return;
        }
        algo.setNumA(numberA);
        algo.setNumB(numberB);
        try {
            System.out.println(algo.calculate());
        } catch (ArithmeticException e) {
            return;
        }
    }

}
