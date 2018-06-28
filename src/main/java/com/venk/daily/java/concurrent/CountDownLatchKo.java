package com.venk.daily.java.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * CountDownLatch类位于java.util.concurrent包下（字面意思为闭锁）。
 * 利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，
 * 此时就可以利用CountDownLatch来实现这种功能了。
 *
 * @Description: 闭锁CountDownLatch
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/6/28 14:14
 * @version: V1.0
 * @url: http://www.importnew.com/21889.html
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class CountDownLatchKo {
    public static void main(String[] args) {
        // 参数count为计数值
        final CountDownLatch latch = new CountDownLatch(2);

        // 子线程1
        new Thread() {
            public void run() {
                dealSomething(latch);
            }
        }.start();

        // 子线程2
        new Thread() {
            public void run() {
                dealSomething(latch);
            }
        }.start();

        try {
            log.info("等待2个子线程执行完毕...");
            latch.await();
            log.info("2个子线程已经执行完毕");
            log.info("继续执行主线程");
        } catch (InterruptedException e) {
            log.error("InterruptedException!", e);
        }

    }

    private static void dealSomething(CountDownLatch latch) {
        try {
            log.info("子线程 {} 正在执行", Thread.currentThread().getName());
            Thread.sleep(1500);
            log.info("子线程 {} 执行完毕", Thread.currentThread().getName());
            latch.countDown();
        } catch (InterruptedException e) {
            log.error("InterruptedException!", e);
        }
    }

}