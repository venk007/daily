package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 加奶泡
 * 具体装饰类
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-04-03 17:48
 */
public class AddFoam extends Step {

    public AddFoam(Make make) {
        super(make);
    }

    @Override
    public void doing() {
        System.out.println("foam🍨");
        this.make.doing();
    }

}
