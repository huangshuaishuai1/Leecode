package dp;

import java.util.ArrayList;
import java.util.List;

public class T1027 {

    public static void main(String[] args) {
        T1027 t1027 = new T1027();
        int i = t1027.longestArithSeqLength(new int[]{9, 4, 7, 2, 10});
        System.out.println(i);
    }
    public int longestArithSeqLength(int[] nums) {
        // dp[i] 表示以nums[i] 结尾的 最长子序列的长度
        int[] dp = new int[nums.length];
        // arr[i] 表示以nums[i] 结尾最长等差序列的一个公差list
        ArrayList<List<Integer>> list = new ArrayList<>();

        dp[0] = 1;
        int ans = 1;
        list.add(new ArrayList<>());
        for (int i = 1; i < nums.length; i++) {
            int len = 1;
            ArrayList<Integer> now = null;
            for (int j = i-1; j >= 0 ; j--) {
                ArrayList<Integer> tmp = new ArrayList<>();
                if (j != 0) {
                    if (dp[j] + 1 > len) {
                        List<Integer> integers = list.get(j);
                        int gap = nums[i] - nums[j];
                        if (integers.contains(gap)) {
                            tmp.add(gap);
                        }
                        if (!tmp.isEmpty()) {
                            len = dp[j] +1;
                            now = tmp;
                        }
                    } else if (dp[j] +1 == len) {
                        List<Integer> integers = list.get(j);
                        int gap = nums[i] - nums[j];
                        if (integers.contains(gap)) {
                            now.add(gap);
                        }
                    }
                }else {
                    if (len == 1) {
                        for (int k = 0; k < i; k++) {
                            tmp.add(nums[i]-nums[k]);
                        }
                        now=tmp;
                        len=2;
                    }
                }

            }
            ans = Math.max(ans,len);
            dp[i] = len;
            list.add(now);
        }
        return ans;
    }

}
