package hot100;

import java.util.Stack;

public class T20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c=='{') {
                stack.add(c);
            }else if(c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if(c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if(c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }

        }
        return stack.isEmpty();
    }

}
