package yxaq;

import java.util.Objects;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.getMaxCount(new String[]{"A", "B", "B", "B", "A","B","B"}));

    }

    public int getMaxCount (String[] pos) {
        // write code here
        int ans = 0;
        for (int i = 0; i < pos.length; i++) {
            if (Objects.equals(pos[i], "A")) {
                if (i < pos.length-1) {
                    pos[i+1] = "C";
                }

                if (i > 0) {
                    pos[i-1] = "C";
                }
            }
        }
        int len = 0;
        for (int i = 0; i < pos.length; i++) {
            if (Objects.equals(pos[i], "A") || Objects.equals(pos[i], "C")) {
                if (len % 2 == 0) {
                    ans += len/2;
                }else {
                    ans += len/2 +1;
                }
                len = 0;
            } else {
                len++;
            }
        }
        if (len != 0) {
            if (len % 2 == 0) {
                ans += len/2;
            }else {
                ans += len/2 +1;
            }
        }
        return ans;
    }
}
