package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class T438 {

    public static void main(String[] args) {
        T438 t438 = new T438();
        List<Integer> anagrams = t438.findAnagrams("abab", "ab");
        System.out.println(111);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int window = p.length();
        char[] target = p.toCharArray();
        Arrays.sort(target);
        ArrayList<Integer> ans = new ArrayList<>();
        String t = new String(target);
        for (int i = 0; i <= s.length()-window; i++) {
            String substr = s.substring(i,i+window);
            char[] chars = substr.toCharArray();
            Arrays.sort(chars);
            substr = new String(chars);
            if (Objects.equals(substr, t)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
