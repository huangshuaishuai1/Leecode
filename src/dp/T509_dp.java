package dp;

/**
 * Dp 五步走
 * 1确定dp数组（dp table）以及下标的含义
 * 2确定递推公式
 * 3dp数组如何初始化
 * 4确定遍历顺序
 * 5举例推导dp数组
 */
public class T509_dp {
    // 第一步： 确定dp数组以及下标的含义：
    // dp[i] 表示第i个数的斐波那契数值
    public int fib(int n) {
        int[] dp = new int[n + 1];
        // 确定递推公式：
        // 第二步题目已经给出：F(n) = F(n - 1) + F(n - 2)
        // 第三步：确定数组的初始化：
        dp[0] = 0;
        dp[1] = 1;
        // 第三步：遍历顺序是从前向后遍历
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        T509_dp t509_dp = new T509_dp();
        System.out.println(t509_dp.fib(3));

    }
}
