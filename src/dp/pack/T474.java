package dp.pack;

public class T474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            dp[i][0][0] = 0;
        }
        int[][] strsForInt = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            strsForInt[i] = countNumber(strs[i]);
        }
        // 要把第一层都初始化了
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i < strsForInt[0][0] || j < strsForInt[0][1]) {
                    dp[0][i][j] = 0;
                }else {
                    dp[0][i][j] = 1;
                }
            }
        }

        // 从第二层开始遍历
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (strsForInt[i][0] > j || strsForInt[i][1] > k) {
                        dp[i][j][k] = dp[i-1][j][k];
                    }else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-strsForInt[i][0]][k-strsForInt[i][1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length-1][m][n];
    }

    public int[] countNumber(String number) {
        char[] chars = number.toCharArray();
        int countOne = 0;
        int countZero = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                countZero++;
            }else {
                countOne ++;
            }
        }
        return new int[]{countZero,countOne};
    }
    public static void main(String[] args) {
        T474 t474 = new T474();
        System.out.println(t474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }
}
