package com.venk.daily.book.talkdesignpattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * 简单工厂模式-加法
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2018/4/20 23:53
 */
public class Add extends Algorithm {

    public Add() {
    }

    @Override
    public double calculate() {
        return this.getNumA() + this.getNumB();
    }
}
