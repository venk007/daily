package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 加奶油
 * 具体装饰类
 *
 * @Author: liwenke[liwenke@ldxinyong.com]
 * @Date: 2019-04-03 17:57
 */
public class AddCream extends Step {

    public AddCream(Make make) {
        super(make);
    }

    @Override
    public void doing() {
        System.out.println("cream🍦");
        this.make.doing();
    }

}
