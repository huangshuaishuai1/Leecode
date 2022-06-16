package backstracking;

import java.util.LinkedList;
import java.util.List;

public class T17 {
    public List<String> letterCombinations(String digits) {
        List<String> strings = new LinkedList<String>();
        if (digits.length() == 0) {
            return strings;
        }
        String[] map = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] chars = digits.toCharArray();

        StringBuilder sb = new StringBuilder();
        backStracking(0, map,chars,strings,sb);
        return strings;
    }

    public void backStracking(int startIndex1,  String[] map, char[] input, List<String> ret, StringBuilder sb) {
        if (startIndex1 == input.length) {
            ret.add(new String(sb));
            return;
        }
        int now = input[startIndex1] - 48;
        String s = map[now-2];
        char[] chars = s.toCharArray();
        for(char c : chars)
        {
            sb.append(c);
            backStracking(startIndex1+1,map,input,ret,sb);
            // 回溯
            sb.deleteCharAt(sb.length()-1);
        }


    }

    public static void main(String[] args) {
        T17 t17 = new T17();
        List<String> strings = t17.letterCombinations("234");
        System.out.println(strings);
    }
}
