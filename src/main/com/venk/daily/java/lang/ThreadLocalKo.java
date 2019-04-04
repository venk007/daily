package com.venk.daily.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedInheritableThreadLocal;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * ThreadLocal线程本地变量，不可传递给子线程（可用于Controller与Service解耦等）
 * <p>
 * InheritableThreadLocal变量值会自动传递给所有子线程
 * 但子线程调用set函数设置新值后，对主线程和其它子线程没有影响，只对自己可见
 *
 *  ThreadLocal（线程本地变量）
 * @author Venk[liwenkeq@sina.com]
 * @date 2018/7/2 15:39

 * @Copyright ©2018 Venk. All rights reserved.
 * @url:https://blog.csdn.net/ni357103403/article/details/51970748 InheritableThreadLocal实现原理
 * @url:http://blog.51cto.com/stevex/1289499 InheritableThreadLocal变量的可见性
 */
@Slf4j
public class ThreadLocalKo {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static ThreadLocal<String> namedInheritableTL = new NamedInheritableThreadLocal<>("inheritableName");

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("ThreadLocal");
        namedInheritableTL.set("NamedInheritableThreadLocal");
        log.info("ThreadLocal: {}", threadLocal.get());
        log.info("NamedInheritableThreadLocal: {}", namedInheritableTL.get());
        Thread t = new Thread(() -> {
            log.info("子线程中的ThreadLocal: {}", threadLocal.get());
            log.info("子线程中的NamedInheritableThreadLocal: {}", namedInheritableTL.get());
            namedInheritableTL.set("NewValue");
            log.info("子线程中修改后的NamedInheritableThreadLocal: {}", namedInheritableTL.get());
            log.info("NamedInheritableThreadLocal的Name: {}", namedInheritableTL.toString());
            namedInheritableTL.remove();
            log.info("子线程中删除后的NamedInheritableThreadLocal: {}", namedInheritableTL.get());
        });
        t.start();
        Thread.sleep(10);
        ThreadLocalFuncKo.threadLocaldemo();
        log.info("原始线程的ThreadLocal: {}", threadLocal.get());
        log.info("原始线程的NamedInheritableThreadLocal: {}", namedInheritableTL.get());
        threadLocal.remove();
        namedInheritableTL.remove();
        log.info("删除后的ThreadLocal: {}", threadLocal.get());
        log.info("删除后的NamedInheritableThreadLocal: {}", namedInheritableTL.get());
    }

}
