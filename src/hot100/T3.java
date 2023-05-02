package hot100;

import java.util.HashMap;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character,Integer> set1 = new HashMap<>();


        char[] array = s.toCharArray();
        int[][] ret = new int[array.length][2];
        ret[0][0] = 1;
        ret[0][1] = 0;
        set1.put(array[0],0);
        for(int i = 1; i < array.length; i++) {
            if (!set1.containsKey(array[i])) {
                ret[i][0] = ret[i-1][0]+1;
                ret[i][1] = ret[i-1][1];
                set1.put(array[i],i);
            }else {

                ret[i][1] = Math.max(ret[i-1][0],ret[i-1][1]);
                int last = set1.get(array[i]);
                ret[i][0] = i - last;
                set1.clear();
                for(int j = last+1; j <= i; j++) {
                    set1.put(array[j],j);
                }

            }
        }
        return Math.max(ret[array.length-1][0],ret[array.length-1][1]);
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.lengthOfLongestSubstring("nfpdmpi"));
    }
}
