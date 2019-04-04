package com.venk.daily.java.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description: 栅栏CyclicBarrier
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/6/28 14:29
 * @version: V1.0
 * @url: http://www.importnew.com/21889.html
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class CyclicBarrierKo {

    public static void main(String[] args) {
        // 0.定义线程数量
        int threadNum = 4;
        // 1.执行CyclicBarrier
        log.info("========= 执行CyclicBarrier =========");
        log.info("\n====================================\n假若有若干个线程都要进行写数据操作\n并且只有所有线程都完成写数据操作之后\n这些线程才能继续做后面的事情\n此时就可以利用CyclicBarrier\n====================================");
        CyclicBarrier barrier = new CyclicBarrier(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Writer(barrier).start();
        }
        sleep();
        // 2.执行带Runnable参数的CyclicBarrier
        log.info("========= 执行带Runnable参数的CyclicBarrier =========");
        log.info("\n====================================\n在所有线程写入操作完之后\n进行额外的其他操作可以为CyclicBarrier提供Runnable参数\n当所有的线程都到达barrier状态后\n最后一个到达的barrier的线程去执行Runnable\n====================================");
        CyclicBarrier barrierWithTask = new CyclicBarrier(threadNum, () -> log.info("当前线程 {} 执行额外操作", Thread.currentThread().getName()));
        for (int i = 0; i < threadNum; i++) {
            new Writer(barrierWithTask).start();
        }
        sleep();
        // 3.重用CyclicBarrier
        log.info("========= 重用CyclicBarrier =========");
        log.info("\n====================================\nCyclicBarrier可以进行重用\n在初次的4个线程越过barrier状态后\n又可以用来进行新一轮的使用\n而 闭锁CountDownLatch 无法进行重复使用\n====================================");
        for (int i = 0; i < threadNum; i++) {
            new Writer(barrier).start();
        }

    }

    static class Writer extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            log.info("线程 {} 正在写入数据...", Thread.currentThread().getName());
            try {
                // 以睡眠来模拟写入数据操作
                Thread.sleep(1500);
                log.info("线程 {} 写入数据完毕，等待其他线程写入完毕", Thread.currentThread().getName());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                log.error("InterruptedException!", e);
            } catch (BrokenBarrierException e) {
                log.error("BrokenBarrierException!", e);
            }
            log.info("所有线程写入完毕，继续处理其他任务...");
        }

    }

    /**
     * 线程等待
     */
    private static void sleep() {
        try {
            Thread.sleep(3000);
            log.info("");
        } catch (InterruptedException e) {
            log.error("InterruptedException!", e);
        }
    }

}