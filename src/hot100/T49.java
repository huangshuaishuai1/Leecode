package hot100;

import java.util.*;

public class T49 {
    public static void main(String[] args) {
        T49 t49 = new T49();
        List<List<String>> lists = t49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(111);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0) {
            return Collections.emptyList();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (map.containsKey(s)) {
                List<String> strings = map.get(s);
                strings.add(strs[i]);
                map.put(s,strings);
            }else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(s,strings);
            }
        }

        ArrayList<List<String>> ans = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            ans.add(map.get(string));
        }
        return ans;
    }
}
