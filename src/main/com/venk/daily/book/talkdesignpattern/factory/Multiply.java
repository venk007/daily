package com.venk.daily.book.talkdesignpattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * 简单工厂模式-乘法
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2018/4/21 00:00
 */
public class Multiply extends Algorithm {

    public Multiply() {
    }

    @Override
    public double calculate() {
        return this.getNumA() * this.getNumB();
    }
}
