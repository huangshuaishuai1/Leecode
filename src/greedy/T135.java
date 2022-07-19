package greedy;

import java.util.ArrayList;

public class T135 {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            candys[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candys[i] = candys[i-1]+1;
            }
        }

        for (int i = candys.length-2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]) {
                candys[i] = candys[i+1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < candys.length; i++) {
            sum += candys[i];
        }

        return sum;


    }

    public static void main(String[] args) {
        T135 t135 = new T135();
        System.out.println(t135.candy(new int[]{1, 3,2,2,1}));
    }
}
