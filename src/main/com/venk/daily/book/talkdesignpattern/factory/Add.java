package com.venk.daily.book.talkdesignpattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description:简单工厂模式-加法
 * @author:Venk[liwenkeq@sina.com]
 * @date:2018/4/20 23:53
 * @version:V1.0
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public class Add extends Algorithm{

    public Add() {
    }

    @Override
    public double calculate() {
        return this.getNumA() + this.getNumB();
    }
}
