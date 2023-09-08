package xc;

import java.util.HashSet;
import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int ans = 0;

        int right = 0;
        for (int i = 0; i < str.length(); i++) {
            int zeroCount = 0;
            int oneCount = 0;
            if (str.charAt(i) == '1' && zeroCount == 0) {
                continue;
            }

            right = i;
            while (right++ < str.length()) {
                if (str.charAt(right) == '1') {
                    oneCount++;
                }else {
                    zeroCount++;
                }
                if (zeroCount > oneCount) {
                    ans++;
                } else {
                    break;
                }
            }


        }
        System.out.println(ans);

    }
}
