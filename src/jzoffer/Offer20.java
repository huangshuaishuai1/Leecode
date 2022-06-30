package jzoffer;

import java.util.HashSet;

public class Offer20 {
    public boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        String s1 = s.trim();
        char[] chars = s1.toCharArray();
        char[] validChar = {'0','1','2','3','4','5','6',
        '7','8','9','-','+','e','E','.'};
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < validChar.length; i++) {
            characters.add(validChar[i]);
        }
        // e和E的数量
        int eCount = 0;
        int eIndex = 0;
        int typeCount = 0;
        int dotCount = 0;
        int dotIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!characters.contains(chars[i])) {
                return false;
            }
            if (chars[i] == 'e' || chars[i] == 'E') {
                eCount++;
                eIndex = i;
                if (eIndex == 0 || eIndex == chars.length-1) {
                    return false;
                }
            }
            else if (chars[i] == '-' || chars[i] == '+'){
                typeCount ++;
                if (i == chars.length-1) {
                    return false;
                }
            }else if (chars[i] == '.') {
                dotCount ++;
                dotIndex = i;
            }
            if (eCount > 1 || typeCount > 2 || dotCount > 1) {
                return false;
            }
        }
        if (eCount >0 && dotCount >0 && eIndex < dotIndex) {
            return false;
        }
        if (eCount >0) {
            String ahead = s1.substring(0,eIndex);
            String behind = s1.substring(eIndex+1);
            if (dotCount >0 ) {
                boolean aheadBoo = isFloat(ahead);
                boolean behindBoo = isInteger(behind);
                return aheadBoo && behindBoo;
            }else {
                boolean aheadBoo = isInteger(ahead);
                boolean behindBoo = isInteger(behind);
                return aheadBoo && behindBoo;
            }
        }else {
            if (typeCount > 1) {
                return false;
            }
            if (dotCount >0 ) {
                return isFloat(s1);
            }else {
                return isInteger(s1);
            }
        }
    }


    // 判断是否是一个整数
    public boolean isInteger(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            start = 1;
        }

        if (chars.length - start == 0) {
            return false;
        }
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                return false;
            }
        }
        return true;

    }

    public boolean isFloat(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            start = 1;
        }
        if (chars.length - start <= 1) {
            return false;
        }

        return true;


    }
    public static void main(String[] args) {
        Offer20 offer20 = new Offer20();
        boolean number = offer20.isNumber("");
        System.out.println(number);
    }
}
