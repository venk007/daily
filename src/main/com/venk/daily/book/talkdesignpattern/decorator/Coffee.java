package com.venk.daily.book.talkdesignpattern.decorator;

/**
 * 咖啡
 * 被装饰类
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2019-04-03 17:13
 */
public class Coffee implements Make {

    @Override
    public void doing() {
        System.out.println("Take your Coffee ☕️");
    }

}
