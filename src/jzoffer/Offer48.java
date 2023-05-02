package jzoffer;

import java.util.HashMap;
import java.util.HashSet;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int[][] dp = new int[s.length()][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        map.put(chars[0],0);

        for (int i = 1; i < chars.length; i++) {
            if(map.containsKey(chars[i]) && map.get(chars[i]) >= i - dp[i-1][0]) {
                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
                dp[i][0] = i - map.get(chars[i]);
                map.put(chars[i],i);
            }else {
                map.put(chars[i],i);
                dp[i][1] = dp[i-1][1];
                dp[i][0] = dp[i-1][0] + 1;
            }
        }
        return Math.max(dp[s.length()-1][0],dp[s.length()-1][1]);

    }

    public static void main(String[] args) {
        Offer48 offer48 = new Offer48();
        int abcabcabc = offer48.lengthOfLongestSubstring("cedvabdfce");
        System.out.println(abcabcabc);

    }
}
