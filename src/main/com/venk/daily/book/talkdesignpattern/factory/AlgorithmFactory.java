package com.venk.daily.book.talkdesignpattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * 简单工厂模式-Factory
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2018/4/21 00:09
 */
public class AlgorithmFactory {

    public static Algorithm getAlgorithm(AlgorithmType algorithmType) {
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

}
