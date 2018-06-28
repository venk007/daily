package com.venk.daily.leetcode.algorithms;

/**
 * 12. Integer to Roman
 *
 * @author:liwenke[li_wk@suixingpay.com]
 * @date:2017/10/9 13:27
 * @url:https://leetcode.com/problems/integer-to-roman/description/ RomanNumber sample:
 * I:1 V:5 X:10 L:50 C:100 D:500 M:1000
 * 1 I 2 II 3 III 4 IV 5 V 6 VI 7VII 8 VIII 9 IX 10 X 11 XI 12 XII 13 XIII 14 XIV 15 XV
 * 20 XX 30 XXX 40 XL 50 L 60 LX 70 LXX 80 LXXX 90 XC
 * 100 C 101 CI 200 CC 500 D 600 DC 900 CM 1000 M 1666 MDCLXVI 1970 MCMLXX
 */
public class IntToRoman {

    private static final int MIN = 1;
    private static final int MAX = 3999;
    //Roman-Number
    private static final int ROMAN_M_1000 = 1000;
    private static final int ROMAN_D_500 = 500;
    private static final int ROMAN_C_100 = 100;
    private static final int ROMAN_L_50 = 50;
    private static final int ROMAN_X_10 = 10;
    private static final int ROMAN_V_5 = 5;
    private static final int ROMAN_I_1 = 1;
    //Roman-Word
    private static final String ROMAN_M = "M";
    private static final String ROMAN_D = "D";
    private static final String ROMAN_C = "C";
    private static final String ROMAN_L = "L";
    private static final String ROMAN_X = "X";
    private static final String ROMAN_V = "V";
    private static final String ROMAN_I = "I";

    /**
     * dealOnce's param and result
     */
    private static class DealParamAndResult {
        int num;
        StringBuilder resultSbd;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public StringBuilder getResultSbd() {
            return resultSbd;
        }

        public void setResultSbd(StringBuilder resultSbd) {
            this.resultSbd = resultSbd;
        }
    }

    /**
     *
     * @param num
     * @return romanWord
     */
    public static String intToRoman(int num) {
        StringBuilder resultSbd = new StringBuilder();
        if (num < MIN || num > MAX) {
            return "";
        }
        DealParamAndResult param = new DealParamAndResult();
        param.setNum(num);
        param.setResultSbd(resultSbd);
        //System.out.println("needDealNum:" + param.getNum() + ",roman:" + param.getResultSbd().toString());
        dealOnce(param, ROMAN_M_1000, ROMAN_M, null);
        dealOnce(param, ROMAN_D_500, ROMAN_D, ROMAN_M);
        dealOnce(param, ROMAN_C_100, ROMAN_C, ROMAN_D);
        dealOnce(param, ROMAN_L_50, ROMAN_L, ROMAN_D);
        dealOnce(param, ROMAN_X_10, ROMAN_X, ROMAN_L);
        dealOnce(param, ROMAN_V_5, ROMAN_V, ROMAN_L);
        //System.out.println("needDealNum:" + param.getNum() + ",roman:" + param.getResultSbd().toString());
        dealOnce(param, ROMAN_I_1, ROMAN_I, ROMAN_V);
        System.out.println("num:" + num + ",result:" + param.getResultSbd().toString());
        return param.getResultSbd().toString();
    }

    /**
     * dealToRoman
     *
     * @param param
     * @param romanNum
     * @param romanWord
     * @param lastRomanWord
     * @return
     */
    private static DealParamAndResult dealOnce(DealParamAndResult param, int romanNum, String romanWord, String lastRomanWord) {
        int mNum = param.getNum() / romanNum;
        if (mNum != 0) {
            if (mNum == 4) {
                if (null != param.getResultSbd() && param.getResultSbd().length() > 1) {
                    param.setResultSbd(new StringBuilder(param.getResultSbd().substring(0, param.getResultSbd().length() - 1)));
                }
                param.getResultSbd().append(romanWord).append(lastRomanWord);
            } else {
                for (int i = 0; i < mNum; i++) {
                    param.getResultSbd().append(romanWord);
                }
            }
        }
        param.setNum(param.getNum() - mNum * romanNum);
        return param;
    }

    public static void main(String[] args) {
        /*
        intToRoman(1666); //MDCLXVI
        intToRoman(1970); //MCMLXX
        intToRoman(90); //XC
        intToRoman(80); //LXXX
        intToRoman(45); //XLV
        intToRoman(14); //XIV
        */
        intToRoman(9); //IX
        /*
        intToRoman(4); //IV
        */
    }

}
