package com.venk.daily.book.talkDesignPattern.factory;

import java.util.Objects;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description:简单工厂模式-Factory
 * @author:Venk[liwenkeq@sina.com]
 * @date:2018/4/21 00:09
 * @version:V1.0
 * @Copyright ©2018 Venk7. All rights reserved.
 */
public class AlgorithmFactory {

    public static Algorithm getAlgorithm(String symbol) {

        switch (symbol) {
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            default:
                System.out.println("运算符号错误，请重新输入!");
                return null;
        }
    }

    public static void main(String[] args) {

        double numberA = 4d;
        double numberB = 2d;
        String symbol = "+";

        System.out.println("halo");
        Algorithm algo = getAlgorithm(symbol);
        if (Objects.isNull(algo)) {
            return;
        }
        algo.setNumA(numberA);
        algo.setNumB(numberB);
        try {
            System.out.println(algo.calculate());
        } catch (ArithmeticException e) {
            return;
        }
    }
}
