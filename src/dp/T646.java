package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class T646 {
    public static void main(String[] args) {
        T646 t646 = new T646();
        int [][] numbers = new int[3][2];
        numbers[0]=new int[]{1,100};
        numbers[1]=new int[]{7,8};
        numbers[2]=new int[]{9,10};

        System.out.println(t646.findLongestChain(numbers));
    }

    public int findLongestChain(int[][] pairs) {
        List<int[]> collect = Arrays.stream(pairs).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        }).collect(Collectors.toList());
        int[] dp = new int[collect.size()];

        int start = collect.get(0)[0];
        int maxLen = collect.get(0)[1];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < collect.size(); i++) {
             if (collect.get(i)[0] > maxLen) {
                start = collect.get(i)[0];
                maxLen = collect.get(i)[1];
                dp[i] = dp[i-1]+1;
            } else if (collect.get(i)[1] <= maxLen) {
                dp[i] = dp[i-1];
                start = collect.get(i)[0];
                maxLen = collect.get(i)[1];
            }else{
                dp[i] = dp[i-1];
            }


        }
        return dp[dp.length-1];
    }
}
