package com.venk.daily.java.gzip;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * All rights Reserved, Designed By Venk.
 * <p>
 * 使用线程池进行递归压缩
 *
 * @author Venk[liwenkeq@sina.com]
 * @date 2018/8/16 15:53
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class GzipFiles {

    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors() + 1;

    private static ExecutorService executorService = newFixedThreadPool(THREAD_COUNT);

    static {
        log.info("FixedThreadPool线程池已创建，线程池大小:{}", THREAD_COUNT);
    }

    public static void Gzip(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                Gzip(f);
            }
        } else {
            GzipRunnable gzipRunnable = new GzipRunnable(file);
            executorService.submit(gzipRunnable);
        }
    }

    public static void shutdown() {
        executorService.shutdown();
        log.info("线程池关闭......");
    }

}
