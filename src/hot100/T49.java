package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class T49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashSet<String> used = new HashSet<>();
        ArrayList<List<String>> ans = new ArrayList<>();

        for (String str : strs) {

        }
        return null;
    }

    public static HashMap<Character, Integer> helper(String str) {
        HashMap<Character, Integer> ans = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            ans.put(str.charAt(i),ans.getOrDefault(str.charAt(i),0));
        }
        return ans;
    }
}
