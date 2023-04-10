package niuke;

import java.util.Scanner;

public class ZiJie1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            String mid = helper(str);
            System.out.println(helper2(mid));
        }
    }

    private static String helper2(String mid) {
        // 维护一个大小为4的窗口
        if (mid.length() < 4) {
            return mid;
        }
        StringBuilder sb = new StringBuilder(mid);
        for (int i = 0; i < sb.length()-3; i++) {
            int start = i;
            int end = start + 4;
            String sub = sb.substring(start,end);
            // 判断是否窗口内的前两个字母是否相等，后两个是否相等，需要同时的
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(2) == sub.charAt(3)) {
                sb.deleteCharAt(start+3);
                i--;
            }
        }
        return new String(sb);
    }

    private static String helper(String str) {
        // 维护一个大小为3的窗口
        if (str.length() < 3) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length()-2; i++) {
            int start = i;
            int end = start + 3;
            String sub = sb.substring(start,end);
            // 判断是否窗口内的三个字母是相等的
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(0) == sub.charAt(2)) {
                sb.deleteCharAt(start+2);
                i--;
            }
        }
        return new String(sb);
    }


}
