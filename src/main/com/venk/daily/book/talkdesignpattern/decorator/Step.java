package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 制作步骤
 * 基础装饰类，子类是赋有具体装饰效果的装饰产品类
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-04-03 17:17
 */
public class Step implements Make {

    protected Make make;

    public Step(Make make) {
        this.make = make;
    }

    @Override
    public void doing() {
    }

}
