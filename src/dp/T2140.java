package dp;

public class T2140 {
    public static void main(String[] args) {
        T2140 t2140 = new T2140();
        System.out.println(t2140.mostPoints(new int[][]{{100,5},{1,1},{1,2},{1,1}}));
    }

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        int[] dp = new int[n + 1];

        for (int i = n-1; i >=0; i--) {
             if (i + questions[i][1] + 1 < n) {
                 dp[i] = Math.max(dp[i+1], questions[i][0] + dp[i + questions[i][1] + 1]);
             } else {
                 dp[i] = Math.max(questions[i][0], dp[i+1]);
             }
        }

        return dp[0];
    }
}
