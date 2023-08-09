package str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class T49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<Integer,HashMap<Integer, Integer>> maps = new HashMap<>();
        ArrayList<List<String>> strList = new ArrayList<>();
        ArrayList<List<String>> ans = new ArrayList<>();
        int[] parent = new int[strs.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            ArrayList<String> strings = new ArrayList<>();
            strings.add(strs[i]);
            strList.add(strings);
        }
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            HashMap<Integer, Integer> map = maps.getOrDefault(i, new HashMap<>());
            for (int j = 0; j < str.length(); j++) {
                int idx = str.charAt(i) - 'a';
                Integer count = map.getOrDefault(idx, 0);
                map.put(idx,count+1);
            }
            maps.put(i,map);
        }


        for (int i = 0; i < strs.length; i++) {
            for (int j = i+1; j < strs.length; j++) {
                if (strs[i].length() != strs[j].length()) {
                    continue;
                }
                HashMap<Integer, Integer> iMap = maps.get(i);
                HashMap<Integer, Integer> jMap = maps.get(j);
                Set<Integer> keySet = iMap.keySet();
                for (Integer integer : keySet) {
                    if (iMap.get(integer) != jMap.get(integer)) {
                        continue;
                    }
                }
                // 合并
                union(i,j,strList,parent);
            }
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                List<String> strings = strList.get(i);
                ans.add(strings);
            }
        }
        return ans;
    }

    void union(int i, int j, ArrayList<List<String>> strList, int[] parent) {
        int iP = findParent(i,parent);
        int jP = findParent(j,parent);
        List<String> strI = strList.get(iP);
        List<String> strJ = strList.get(jP);

        if (iP < jP) {
            parent[jP] = iP;
            for (int k = 0; k < strJ.size(); k++) {
                if (!strI.contains(strJ.get(k))) {
                    strI.add(strJ.get(k));
                }
            }
        }else {
            parent[iP] = jP;
        }
    }

    int findParent(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return findParent(parent[i],parent);
    }
}
