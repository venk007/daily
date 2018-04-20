package com.venk.daily.book.talkDesignPattern.factory;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description:简单工厂模式-运算类
 * @author:Venk[liwenkeq@sina.com]
 * @date:2018/4/20 23:47
 * @version:V1.0
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public abstract class Algorithm {

    private double numA;

    private double numB;

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    public abstract double calculate();

}
