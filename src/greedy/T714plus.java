package greedy;

public class T714plus {
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int ret = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }else if (prices[i] > buy) {
                ret += prices[i] - buy;
                buy = prices[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T714plus t714plus = new T714plus();
        int i = t714plus.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);

        System.out.println(i);
    }
}
