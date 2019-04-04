package com.venk.daily.book.talkdesignpattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * 简单工厂模式-减法
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2018/4/20 23:58
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public class Subtract extends Algorithm {

    public Subtract() {
    }

    @Override
    public double calculate() {
        return this.getNumA() - this.getNumB();
    }
}
