package com.venk.daily.src.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * All rights Reserved, Designed By Liwenke.
 *
 * @author:liwenke[liwenke007@gmail.com]
 * @date:2017/9/29 17:51
 */
@Slf4j
@Controller
@RequestMapping("/")
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        log.info("------>>> hello");
        String result = "Halo,Venk!~";
        return result;
    }

    @ResponseBody
    @RequestMapping("helloMsg")
    public String helloMsg(String msg) {
        log.info("------>>> helloMsg , msg:{}", msg);
        StringBuffer sbf = new StringBuffer("Halo,SpringBoot!<br>msg:").append(msg);
        return sbf.toString();
    }

}
