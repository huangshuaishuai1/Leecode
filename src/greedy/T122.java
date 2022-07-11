package greedy;

import java.util.ArrayList;

public class T122 {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high =-1;
        int sum = 0;
        for (int i = 1; i < prices.length; ) {
            int count = 0;
            if (prices[i] < low) {
                low = prices[i];
                count ++;
            }else {
                int j = i;
                for (j = i; j < prices.length; j++) {
                    if (prices[j] > high) {
                        high = prices[j];
                        count ++;
                    }else {
                        break;
                    }
                }
                sum += high - low;
                low = high;
                high = -1;
            }
            i+=count;
        }
        return sum;
    }

    public static void main(String[] args) {
        T122 t122 = new T122();
        System.out.println(t122.maxProfit(new int[]{2,1,2,0,1}));
    }

}
