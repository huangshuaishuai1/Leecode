package dp;

import java.util.HashSet;

public class T983 {
    public static void main(String[] args) {
        T983 t983 = new T983();
        System.out.println(t983.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            set.add(days[i]);
        }
        int one = costs[0];
        int week = costs[1];
        int month = costs[2];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (set.contains(i)) {
                dp[i] = Math.min(Math.min(dp[i-1] + one,dp[Math.max(i-7,0)] + week),dp[Math.max(i-30,0)] + month);
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
