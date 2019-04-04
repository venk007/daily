package com.venk.daily.book.talkdesignpattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * 简单工厂模式-除法
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2018/4/21 00:02
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
