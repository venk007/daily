package com.venk.daily.java.lang;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */
public class HashSetKo {

    /**
     * HashSet删除null值
     * @param args
     */
    public static void main(String[] args){
        HashSet<String> strSet = new HashSet<>();
        strSet.add("01");
        strSet.add(null);
        strSet.add("02");
        strSet.add("03");
        System.out.println(strSet);
        strSet.remove(null);
        System.out.println(strSet);
        Iterator<String> iterator = strSet.iterator();
        while(iterator.hasNext()) {
            if(iterator.next() == null) {
                iterator.remove();
            }
        }
        System.out.println(strSet);
    }

}