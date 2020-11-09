package com.personal.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * “不知道什么的”字符替换为英文字母
     * @param args
     */
    public static void main(String[] args) {
        String s = "ｚｅｔｔａｂｙｔｅ";
        s = s.replaceAll(" ","");
        System.out.println(s);
        System.out.println( convertMoString(s).toLowerCase() );
    }

    public static synchronized String convertMoString(String sMo) {
        String sReturn = sMo;
        if (sReturn == null) {
            return sReturn;
        }
        try {
            //sReturn = sReturn.toUpperCase();
            sReturn = sReturn.replace('，', ',');
            sReturn = sReturn.replace('．', '.');
            sReturn = sReturn.replace('；', ';');
            sReturn = sReturn.replace('！', '!');
            sReturn = sReturn.replace('？', '?');
            sReturn = sReturn.replace('：', ':');
            sReturn = sReturn.replace('"', '＂');
            sReturn = sReturn.replace('“', '＂');
            sReturn = sReturn.replace('”', '＂');
            sReturn = sReturn.replace('－', '-');
            // sReturn = sReturn.replace('_', ' ');
            sReturn = sReturn.replace('，', ',');
            sReturn = sReturn.replace('０', '0');
            sReturn = sReturn.replace('１', '1');
            sReturn = sReturn.replace('２', '2');
            sReturn = sReturn.replace('3', '3');
            sReturn = sReturn.replace('４', '4');
            sReturn = sReturn.replace('5', '5');
            sReturn = sReturn.replace('6', '6');
            sReturn = sReturn.replace('7', '7');
            sReturn = sReturn.replace('8', '8');
            sReturn = sReturn.replace('9', '9');
            sReturn = sReturn.replace('ａ', 'A');
            sReturn = sReturn.replace('ｂ', 'B');
            sReturn = sReturn.replace('ｃ', 'C');
            sReturn = sReturn.replace('ｄ', 'D');
            sReturn = sReturn.replace('ｅ', 'E');
            sReturn = sReturn.replace('F', 'F');
            sReturn = sReturn.replace('ｇ', 'G');
            sReturn = sReturn.replace('ｈ', 'H');
            sReturn = sReturn.replace('ｉ', 'I');
            sReturn = sReturn.replace('J', 'J');
            sReturn = sReturn.replace('K', 'K');
            sReturn = sReturn.replace('ｌ', 'L');
            sReturn = sReturn.replace('ｍ', 'M');
            sReturn = sReturn.replace('ｎ', 'N');
            sReturn = sReturn.replace('ｏ', 'O');
            sReturn = sReturn.replace('ｐ', 'P');
            sReturn = sReturn.replace('Q', 'Q');
            sReturn = sReturn.replace('ｒ', 'R');
            sReturn = sReturn.replace('ｓ', 'S');
            sReturn = sReturn.replace('ｔ', 'T');
            sReturn = sReturn.replace('ｕ', 'U');
            sReturn = sReturn.replace('ｖ', 'V');
            sReturn = sReturn.replace('ｗ', 'W');
            sReturn = sReturn.replace('ｘ', 'X');
            sReturn = sReturn.replace('ｙ', 'Y');
            sReturn = sReturn.replace('ｚ', 'Z');
            sReturn = strReplace(sReturn, "‘", "'");
        } catch (Exception ex) {
            return sMo;
        }
        return sReturn;
    }

    public static synchronized String strReplace(String sAll, String sOld,String sNew) {
        int iT = 0;
        String sF = null;
        String sH = null;
        /* 如果新串中包括旧串,不让替多只让替少 */
        if (sNew.indexOf(sOld) != -1) {
            return sAll;
        }
        if ((sAll == null) || (sOld == null) || (sNew == null)) {
            return sAll;
        }
        iT = sAll.indexOf(sOld);
        while (iT != -1) {
            sF = sAll.substring(0, iT);
            sH = sAll.substring(iT + sOld.length());
            sAll = sF + sNew + sH;
            iT = sAll.indexOf(sOld);
        }
        return sAll;
    }

}
