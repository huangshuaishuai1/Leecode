package sxf;

import java.util.Scanner;

public class T2 {
    //模拟正则表达式

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String mode = scanner.next();
        System.out.println(isMatch(str,mode)? 1: 0);
    }

    static boolean isMatch(String str, String mode) {
        if (mode.isEmpty()) {
            return str.isEmpty();
        }
        // 第一个字符是否匹配
        boolean firsetMatch = (!str.isEmpty() && (str.charAt(0) == mode.charAt(0)|| mode.charAt(0)=='.'));

        if (mode.length() >= 2 && mode.charAt(1) == '*') {
            return (isMatch(str,mode.substring(2)) || (firsetMatch && isMatch(str.substring(1),mode)));
        } else {
            return firsetMatch && isMatch(str.substring(1),mode.substring(1));
        }
    }
}
