package dp;

public class T122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i <= prices.length-2; i++) {
            if (prices[i+1]-prices[i] > 0) {
                profit+=(prices[i+1]-prices[i]);
            }
        }
        return profit;

    }

    public static void main(String[] args) {
        T122 t122 = new T122();
        System.out.println(t122.maxProfit(new int[]{1,2,3,4,5}));
    }
}
