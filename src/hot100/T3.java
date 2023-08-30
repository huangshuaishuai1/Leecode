package hot100;

import java.util.HashMap;
import java.util.HashSet;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            ans = Math.max(ans,i-left+1);
            map.put(s.charAt(i),i);
        }
        return ans;
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.lengthOfLongestSubstring("au"));
    }
}
