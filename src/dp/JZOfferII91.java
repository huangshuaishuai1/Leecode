package dp;

public class JZOfferII91 {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length+1][3];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i-1][2];
        }
        int ans = Math.min(dp[dp.length-1][0],dp[dp.length-1][1]);
        return Math.min(ans,dp[dp.length-1][2]);
    }

    public static void main(String[] args) {
        JZOfferII91 jzOfferII91 = new JZOfferII91();
        int[][] numbers = new int[3][3];
        numbers[0][0] = 17;
        numbers[0][1] = 2;
        numbers[0][2] = 17;
        numbers[1][0] = 16;
        numbers[1][1] = 16;
        numbers[1][2] = 5;
        numbers[2][0] = 14;
        numbers[2][1] = 3;
        numbers[2][2] = 19;
        System.out.println(jzOfferII91.minCost(numbers));
    }
}
