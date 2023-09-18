package fiveeight;

import java.util.Arrays;

public class T1 {

    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.calculate(2, 3, new int[]{1, 2, 3, 5, 6, 4}));
    }

    public int calculate (int m, int n, int[] scores) {
        // write code here
        if (scores.length > 2*n || scores.length < 2*m) {
            return -1;
        }

        Arrays.sort(scores);
//        int ansIdx = scores.length - n - 1;
//        int l = scores.length - n;
//        int r = n;
//        while (scores[ansIdx] == scores[ansIdx-1]) {
//            l++;
//            r--;
//            if (l > m || r < n) {
//                return -1;
//            }
//            ansIdx++;
//        }
        int l = m -1 ;
        while (scores.length - l - 1 > n && l < n) {
            l++;
        }
        if (l == n) {
            return -1;
        }else {
            return scores[l];
        }
    }
}
