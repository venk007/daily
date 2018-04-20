package com.venk.daily.book.talkDesignPattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description:简单工厂模式-减法
 * @author:Venk[liwenkeq@sina.com]
 * @date:2018/4/21 00:02
 * @version:V1.0
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public class Divide extends Algorithm {

    public Divide() {
    }

    @Override
    public double calculate() {
        double result = this.getNumA() / this.getNumB();
        if (Double.isInfinite(result)) {
            System.out.println("除数不可为0!");
            throw new ArithmeticException();
        }
        return result;
    }
}
