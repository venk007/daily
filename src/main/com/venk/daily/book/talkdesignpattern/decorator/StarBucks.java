package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 咖啡店
 * 客户端
 *
 * @Author: liwenke[liwenke@ldxinyong.com]
 * @Date: 2019-04-03 17:27
 */
public class StarBucks {

    /**
     * 拿铁
     */
    public static Make latte() {
        System.out.println("\nlatte:");
        return new AddShot(new AddMilk(new Coffee()));
    }

    /**
     * 摩卡
     */
    public static Make mocha() {
        System.out.println("\nmocha:");
        return new AddShot(new AddMilk(new AddCocoa(new AddCream(new Coffee()))));
    }

    /**
     * 卡布奇诺
     */
    public static Make cappuccino() {
        System.out.println("\ncappuccino:");
        return new AddShot(new AddMilk(new AddFoam(new Coffee())));
    }

    /**
     * 焦糖玛奇朵
     */
    public static Make caramelMacchiato() {
        System.out.println("\ncaramelMacchiato:");
        return new AddShot(new AddMilk(new AddFoam(new AddCaramel(new Coffee()))));
    }

    public static void main(String[] args) {
        Make latte = latte();
        latte.doing();

        Make mocha = mocha();
        mocha.doing();

        Make cappuccino = cappuccino();
        cappuccino.doing();

        Make caramelMacchiato = caramelMacchiato();
        caramelMacchiato.doing();
    }

}
