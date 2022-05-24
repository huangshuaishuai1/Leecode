package stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 */
public class T20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((')'==c||']'==c||'}'==c) && stack.isEmpty()) {
                return false;
            }
            if ('(' == c || '['==c || '{'==(c)){
                stack.push(c);
            }else {
                char tem =  stack.pop();
                if (')'==c && !(tem=='(')){
                    return false;
                }else if (']'==c && !(tem=='[')){
                    return false;
                }else if ('}'==c && !(tem == '{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        T20 t20 = new T20();
        System.out.println(t20.isValid("([{(())}])()()()()"));
    }
}
