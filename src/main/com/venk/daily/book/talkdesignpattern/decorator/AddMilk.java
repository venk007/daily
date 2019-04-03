package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 加牛奶
 * 具体装饰类
 *
 * @Author: liwenke[liwenke@ldxinyong.com]
 * @Date: 2019-04-03 17:23
 */
public class AddMilk extends Step{
    
    public AddMilk(Make make) {
        super(make);
    }

    @Override
    public void doing() {
        System.out.println("milk🥛");
        this.make.doing();
    }
}
