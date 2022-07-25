package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class T763 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        HashMap<Character, Integer> curMap = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        int count = 1;
        curMap.put(chars[0],1);
        list.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
//            if (curMap.isEmpty()) {
//                curMap.put(chars[i],1);
//                if (!list.contains(chars[i])){
//                    list.add(chars[i]);
//                }
//                count++;
//            }else {
                if (curMap.containsKey(chars[i])) {
                    curMap.put(chars[i],curMap.get(chars[i])+1);
                    count++;
                }else {
                    int j = 0;
                    for (j = 0; j < list.size(); j++) {
                        Character c = list.get(j);
                        if ( curMap.get(c) < map.get(c)) {
                            curMap.put(chars[i],1);
                            list.add(chars[i]);
                            count++;
                            break;
                        }
                    }
                    if (j == list.size()) {
                        ret.add(count);
                        count = 0;
                        list.clear();
                        curMap.clear();
                        curMap.put(chars[i],1);
                        count = 1;
                        list.add(chars[i]);
                    }
                }
            }
        ret.add(count);
//        }
        return ret;
    }

    public static void main(String[] args) {
        T763 t763 = new T763();
        List<Integer> ababcbacadefegdehijhklij = t763.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(ababcbacadefegdehijhklij);
    }
}
