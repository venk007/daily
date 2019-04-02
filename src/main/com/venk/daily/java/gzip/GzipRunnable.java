package com.venk.daily.java.gzip;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description: 单文件压缩
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/8/16 15:28
 * @version: V1.0
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class GzipRunnable implements Runnable {

    private final File file;

    public GzipRunnable(File file) {
        this.file = file;
    }


    @Override
    public void run() {
        // 1.入参检查
        if (checkFile()) {
            return;
        }
        // 2.定义输出文件
        File outPutFile = new File(file.getParent(), file.getName() + ".gz");
        if (outPutFile.exists()) {
            log.warn("对应的压缩文件已存在！文件名:{}", outPutFile.getName());
            return;
        }
        // 3.压缩进度提醒
        Thread timerThread = TimerStart();
        // 4.开始压缩
        try {
            zip(outPutFile);
        } catch (IOException e) {
            log.error("压缩时发生错误！", e);
        }
        // 5.终止进度提醒
        timerThread.interrupt();
    }

    /**
     * 创建进度提醒线程
     * @return
     */
    private Thread TimerStart() {
        GzipTimer gzipTimer = new GzipTimer(file);
        Thread timerThread = new Thread(gzipTimer);
        timerThread.start();
        return timerThread;
    }

    /**
     * 核心压缩过程
     * @param outPutFile
     * @throws IOException
     */
    private void zip(File outPutFile) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(outPutFile)));
        int bit;
        while ((bit = in.read()) != -1) {
            out.write(bit);
        }
        out.flush();
        in.close();
        out.close();
    }

    /**
     * 文件名称检查
     *
     * @return
     */
    private boolean checkFile() {
        if (file == null) {
            log.warn("文件不存在！");
            return true;
        }
        if (file.getName().endsWith(".gz")) {
            log.warn("该文件已经是压缩文件！文件名:{}", file.getName());
            return true;
        }
        return false;
    }

}
