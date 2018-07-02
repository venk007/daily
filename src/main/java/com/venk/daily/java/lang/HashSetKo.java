package com.venk.daily.java.lang;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */
@Slf4j
public class HashSetKo {

    /**
     * HashSet删除null值
     * @param args
     */
    public static void main(String[] args) {
        HashSet<String> strSet = new HashSet<>();
        strSet.add("01");
        strSet.add(null);
        strSet.add("02");
        strSet.add("03");
        log.info("HashSet:{}", strSet);
        strSet.remove(null);
        log.info("HashSet:{}", strSet);
        Iterator<String> iterator = strSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        log.info("HashSet:{}", strSet);
    }

}