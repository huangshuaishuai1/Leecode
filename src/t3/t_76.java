package t3;

import java.util.HashMap;

public class t_76 {

    public String minWindow(String s, String t) {
        char[] s1 = s.toCharArray();
        Counter counter1 = new Counter();
        char[] s2 = t.toCharArray();
        int start = 0;
        int end = 0;
        String result = "";
        int len = Integer.MAX_VALUE;
        for (char c : s2) {
            counter1.add(c, 1);
        }
        int temp = 0;
        while(end < s1.length) {
            Counter counter = (Counter) counter1.clone();
            while ( start < s1.length && counter.get(s1[start]) == 0 ) {
                start++;
                end ++;
            }
            while (!counter.isEmpty() && end < s1.length) {

                if (counter.get(s1[end]) != 0) {
                    if (end != start && temp == 0) {
                        temp = end;
                    }
                    counter.add(s1[end], -1);
                    if (counter.get(s1[end]) == 0) {
                        counter.remove(s1[end]);
                    }
                }
                end++;
            }
            if (counter.isEmpty()) {
                result = len < (end-start) ?   result:s.substring(start,end);
                len = Math.min(len, end - start);
                if (s1.length != 1){
                    end = temp;
                    start = temp;
                    temp = 0;
                }

            }
//            if (end == s1.length) {
//                break;
//            }

        }
        return result;
    }


    public static void main(String[] args) {

        t_76 f = new t_76();
        String s = f.minWindow("bba", "ab");
        System.out.println(s);
    }

}
class Counter extends HashMap<Character, Integer> {
    public int get(Character key) {
        return containsKey(key)? super.get(key) : 0;
    }

    public void add (Character key, Integer value) {
        put(key, get(key) + value);
    }
}
