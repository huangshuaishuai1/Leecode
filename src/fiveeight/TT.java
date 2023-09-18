package fiveeight;

public class TT {

    public static void main(String[] args) {
        int[] ints = {-100, 1, -200, 3, 4, 300, -10000, 20000};
        // 暴力
//        int ans = Integer.MIN_VALUE;
//        for (int i = 0; i < ints.length; i++) {
//            for (int j = i+1; j < ints.length; j++) {
//                ans = Math.max(ans,ints[j] - ints[i]);
//            }
//        }
        int min = ints[0];
        int max = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > min) {
                max = Math.max(max,ints[i] - min);
            }else {
                min = ints[i];
            }
        }


        System.out.println(max);
    }
}
