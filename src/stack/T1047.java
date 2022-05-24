package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class T1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if (s.charAt(i) == stack.peek()){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        char[] characters = new char[stack.size()];
        Object[] objects = stack.toArray();
        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char) objects[i];
        }
        String ret = new String(characters);
        return ret;
    }

    public static void main(String[] args) {
        T1047 t1047 = new T1047();

        String s = t1047.removeDuplicates("abbacaa");
        System.out.println("s = " + s);
    }
}
