package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 加可可
 * 具体装饰类
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-04-03 17:54
 */
public class AddCocoa extends Step {

    public AddCocoa(Make make) {
        super(make);
    }

    @Override
    public void doing() {
        System.out.println("cocoa🍫");
        this.make.doing();
    }

}
