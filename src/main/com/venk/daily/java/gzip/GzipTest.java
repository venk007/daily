package com.venk.daily.java.gzip;

import java.io.File;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description: 测试入口
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/8/16 16:07
 * @version: V1.0
 * @Copyright ©2018 Venk. All rights reserved.
 */
public class GzipTest {

    public static void main(String[] args){
        File file = new File("/Users/venk/Downloads/木曜四");
        GzipFiles.Gzip(file);
        GzipFiles.shutdown();
    }
}
