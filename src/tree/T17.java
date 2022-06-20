package tree;

import java.util.LinkedList;
import java.util.List;

public class T17 {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> strings = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        String[] number = new String []{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] chars = digits.toCharArray();
        String[] input = new String[digits.length()+1];
        for (int i = 0; i < chars.length; i++) {
            input[i] = number[(int)chars[i]];
        }
        backStracking(input,0,strings, stringBuilder,0);
        return strings;
    }

    public void backStracking(String[] input, int startIndex, LinkedList<String> ret, StringBuilder sb, int startIndex2) {
        if (startIndex == input.length) {
            ret.add(new String(sb));
            return;
        }
        int size = input[startIndex].length()+1;

    }
    public static void main(String[] args) {

    }
}
