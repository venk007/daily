package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 加浓缩
 * 具体装饰类
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-04-03 17:20
 */
public class AddShot extends Step {

    public AddShot(Make make) {
        super(make);
    }

    @Override
    public void doing() {
        System.out.println("espresso🍒");
        this.make.doing();
    }

}
