package array;

import java.util.Scanner;

public class StringAddition {
    public static String add(String a, String b) {
        b = b.replaceAll("^0+", ""); // 去掉开头的零
        a = a.replaceAll("^0+", ""); // 去掉开头的零
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.max(lenA, lenB) + 1; // 最后加出来的长度肯定不会超过a，b最大长度 + 
        // 翻转，从低位逐步求和
        StringBuilder ans = new StringBuilder(new String(new char[len]).replace('\0', '0'));
        // 把a拷贝到ans中
        for (int i = 0; i < lenA; i++) {
            ans.setCharAt(i, a.charAt(i));
        }
        // 主要看这段代码，它是将两个字符串反转后从0开始加的
        int tmp = 0; // tmp是上一位相加后的进位，一开始为0
        for (int i = 0; i < len; i++) {
            int aVal = i < lenA ? (ans.charAt(i) - '0') : 0;
            int bVal = i < lenB ? (b.charAt(i) - '0') : 0;
            tmp += aVal + bVal;
            ans.setCharAt(i, (char) (tmp % 10 + '0'));
            tmp /= 10; // 看是否有进位
        }

        ans.reverse(); // 最后还是要翻转回来
        return ans.substring(ans.indexOf("1")); // 可能会有 0213 的情况，只需返回213
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println("结果: " + add(str1, str2));
        }
    }
}
