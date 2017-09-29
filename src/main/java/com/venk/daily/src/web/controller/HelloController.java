package com.venk.daily.src.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * All rights Reserved, Designed By Liwenke.
 *
 * @author:liwenke[liwenke007@gmail.com]
 * @date:2017/9/29 17:51
 */
@Controller
@RequestMapping("/")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        LOGGER.info("------>>> hello");
        String result = "Halo,Venk!~";
        return result;
    }

    @ResponseBody
    @RequestMapping("helloMsg")
    public String helloMsg(String msg) {
        LOGGER.info("------>>> helloMsg , msg:{}", msg);
        StringBuffer sbf = new StringBuffer("Halo,SpringBoot!<br>msg:").append(msg);
        return sbf.toString();
    }

}
