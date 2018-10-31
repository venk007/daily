package com.venk.daily.java.stream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * All rights Reserved, Designed By Venk.
 *
 * @Description: stream遍历查找字符串
 * @author: Venk[liwenkeq@sina.com]
 * @date: 2018/10/31 16:32
 * @version: V1.0
 * @Copyright ©2018 Venk. All rights reserved.
 */
@Slf4j
public class StringContainsStreamKo {

    static String[] FAMILY_NICK_NAME_ARRAY = {
            "娘", "舅", "叔", "伯", "妗", "姨", "婶",
            "爷", "父亲", "爸", "爹", "奶奶", "母亲", "妈",
            "姑", "侄", "甥", "丈夫", "老公", "妻", "老婆",
            "儿子", "女儿", "孙子", "孙女", "媳", "婿", "外公",
            "外婆", "哥哥", "姐姐", "妹妹", "弟弟", "大哥", "大姐",
            "二哥", "二姐", "二妹", "三哥", "三姐", "三妹", "幺", "老头"};

    static List<String> FAMILY_NICK_NAME_LIST = Arrays.asList(FAMILY_NICK_NAME_ARRAY);

    public static boolean isFamilyNickName(String nickname) {
        return Objects.nonNull(nickname)
                && (!nickname.isEmpty())
                && FAMILY_NICK_NAME_LIST
                .stream()
                .anyMatch(nickname::contains);
    }

    public static boolean isFamilyNickNameForce(String nickname) {
        if (StringUtils.isBlank(nickname)) {
            return false;
        }
        for (String condition : FAMILY_NICK_NAME_LIST) {
            if (nickname.contains(condition)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long startTime = getNow();
        for (int i = 0; i < 10000; i++) {
            isFamilyNickName("悠哈");
        }
        long endTime = getNow();
        log.info("stream time: {} ms", (endTime - startTime));

        startTime = getNow();
        for (int i = 0; i < 10000; i++) {
            isFamilyNickNameForce("悠哈");
        }
        endTime = getNow();
        log.info("force time: {} ms", (endTime - startTime));

        log.info("悠哈:{}", isFamilyNickName("悠哈"));
        log.info("大姐:{}", isFamilyNickName("大姐"));
        log.info("二舅:{}", isFamilyNickName("二舅"));
        log.info("三哥:{}", isFamilyNickName("三哥"));
        log.info("四叔:{}", isFamilyNickName("四叔"));
        log.info("五姨:{}", isFamilyNickName("五姨"));
        log.info("外阿公:{}", isFamilyNickName("外阿公"));
        log.info("小猫咪:{}", isFamilyNickName("小猫咪"));

        log.info("悠哈:{}", isFamilyNickNameForce("悠哈"));
        log.info("大姐:{}", isFamilyNickNameForce("大姐"));
        log.info("二舅:{}", isFamilyNickNameForce("二舅"));
        log.info("三哥:{}", isFamilyNickNameForce("三哥"));
        log.info("四叔:{}", isFamilyNickNameForce("四叔"));
        log.info("五姨:{}", isFamilyNickNameForce("五姨"));
        log.info("外阿公:{}", isFamilyNickNameForce("外阿公"));
        log.info("小猫咪:{}", isFamilyNickNameForce("小猫咪"));
    }

    private static long getNow() {
        return System.currentTimeMillis();
    }
}
