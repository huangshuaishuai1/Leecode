package greedy;

public class T714 {

    public int maxProfit(int[] prices, int fee) {
        int tag = 0;
        int now = prices[0];
//        int move = prices[0];
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {

            if (tag == 0) {
                if (prices[i] -fee-now >0) {
                    ret += prices[i] -fee-now;
                    tag = 1;
                    now = prices[i];
                }else if (prices[i] - now <= 0){
                    now = prices[i];
                }
            }else {
                if (prices[i] - now >= 0) {
                    ret += prices[i] - now;
                    now = prices[i];
                }else if (now - fee <= prices[i]){
                    continue;
                }else {
                    tag = 0;
                    now = prices[i];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T714 t714 = new T714();
        int i = t714.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);

        System.out.println(i);
    }
}
