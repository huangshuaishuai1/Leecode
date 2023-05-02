package jzoffer;

public class Offer46 {
    public int translateNum(int num) {
        String numStr = num + "";
        int[][] dp = new int[numStr.length()][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int i = 1; i < numStr.length(); i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            if(Integer.parseInt(numStr.substring(i-1,i)) !=0 && Integer.parseInt(numStr.substring(i-1,i+1)) >=0 && Integer.parseInt(numStr.substring(i-1,i+1)) < 26) {
                dp[i][1] = dp[i-1][0];
            }
        }
        return dp[numStr.length()-1][0] + dp[numStr.length()-1][1];
    }

    public static void main(String[] args) {
        Offer46 offer46 = new Offer46();
        System.out.println(offer46.translateNum(12258));
    }
}
