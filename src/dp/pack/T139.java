package dp.pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                int len = word.length();
                if (s.length() - i >= len) {
                    if (s.substring(i,i+len).equals(word)) {
                        dp[i+len] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        T139 t139 = new T139();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("cats");
        strings.add("cat");
        strings.add("sand");
        strings.add("dog");
//        strings.add("an");
        System.out.println(t139.wordBreak("catsandog", strings));
    }
}
