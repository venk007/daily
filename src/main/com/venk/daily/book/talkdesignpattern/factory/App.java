package com.venk.daily.book.talkdesignpattern.factory;

import java.util.Objects;

/**
 * 工厂模式
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-04-04 17:15
 */
public class App {

    public static void main(String[] args) {
        double numberA = 4d;
        double numberB = 2d;
        Algorithm algo = AlgorithmFactory.getAlgorithm(AlgorithmType.ADD);
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
