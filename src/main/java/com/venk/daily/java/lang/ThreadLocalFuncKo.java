package com.venk.daily.java.lang;

import lombok.extern.slf4j.Slf4j;

/**
 * All rights Reserved, Designed By Venk.
 * @see ThreadLocalKo
 * @Description: ThreadLocal演示函数
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/7/2 16:52
 * @version: V1.0
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class ThreadLocalFuncKo {

    /**
     * ThreadLocal演示函数
     * 可用于Controller与Service解耦，拦截器过滤设置单线程全局变量等
     */
    public static void threadLocaldemo() {
        log.info("ThreadLocalKo的ThreadLocal: {}", ThreadLocalKo.threadLocal.get());
        log.info("ThreadLocalKo的NamedInheritableThreadLocal: {}", ThreadLocalKo.namedInheritableTL.get());
    }

}
