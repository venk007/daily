package com.venk.daily.java.gzip;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description: 压缩进度提醒器
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/8/16 16:25
 * @version: V1.0
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class GzipTimer implements Runnable {

    private File file;

    private static final int TIME_STEP_MILLIS = 1000;

    public GzipTimer(File file) {
        super();
        this.file = file;
    }

    @Override
    public void run() {
        log.info("正在压缩");
        try {
            while (true) {
                Thread.sleep(TIME_STEP_MILLIS);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            log.info("{}.gz 已经压缩完成", file.getName());
        }
    }

}
