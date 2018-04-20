package com.venk.daily.book.talkDesignPattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description:简单工厂模式-除法
 * @author:Venk[liwenkeq@sina.com]
 * @date:2018/4/20 23:58
 * @version:V1.0
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public class Subtract extends Algorithm{

    public Subtract() {
    }

    @Override
    public double calculate() {
        return this.getNumA() - this.getNumB();
    }
}
