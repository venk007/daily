package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 加焦糖
 * 具体装饰类
 *
 * @Author: venk[liwenke007@gmail.com]
 * @Date: 2019-04-03 17:45
 */
public class AddCaramel extends Step {

    public AddCaramel(Make make) {
        super(make);
    }

    @Override
    public void doing() {
        System.out.println("caramel🍾");
        this.make.doing();
    }

}
