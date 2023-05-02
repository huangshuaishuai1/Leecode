package huawei;

import java.util.ArrayList;
import java.util.Arrays;

public class wangyi1 {

    public static void main(String[] args) {
        wangyi1 wangyi1 = new wangyi1();
        System.out.println(wangyi1.putGems(new int[]{2, 3, 5,6, 4}, 3));
    }
    public int putGems (int[] price, int k) {
        if (k > price.length) {
            return 0;
        }
        if (price.length == 2) {
            if (k == 1) {
                return Math.max(price[0],price[1]) - Math.min(price[0],price[1]);
            }
            return 0;
        }
        int[] tmp = new int[price.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = price[i];
        }
        Arrays.sort(tmp);
        int min = price[0] + price[price.length-1];
        int max = price[0] + price[price.length-1];
        int loop = 2*(k - 1);
        for (int i = 0; i < loop; i++) {
            min += tmp[i];
            max += tmp[tmp.length-1-i];
        }
        return max - min;
    }
}
