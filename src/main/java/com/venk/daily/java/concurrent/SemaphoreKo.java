package com.venk.daily.java.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description: 信号量Semaphore
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/6/28 16:13
 * @version: V1.0
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class SemaphoreKo {

    public static void main(String[] args) {
        /**
         * 初始化工人数
         */
        int wokerNum = 8;
        /**
         * 初始化机器数目
         */
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < wokerNum; i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                log.info("工人 {} 占用一个机器...", this.num);
                Thread.sleep(1000);
                log.info("工人 {} 释放一个机器", this.num);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
