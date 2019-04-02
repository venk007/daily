package com.venk.daily.book.talkdesignpattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description:简单工厂模式-乘法
 * @author:Venk[liwenkeq@sina.com]
 * @date:2018/4/21 00:00
 * @version:V1.0
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public class Multiply extends Algorithm{

    public Multiply() {
    }

    @Override
    public double calculate() {
        return this.getNumA() * this.getNumB();
    }
}
