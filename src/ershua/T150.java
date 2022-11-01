package ershua;

import java.util.Stack;

public class T150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                int newInt = first + second;
                stack.add(newInt);
            } else if ("-".equals(tokens[i])) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                int newInt = first - second;
                stack.add(newInt);
            } else if ("*".equals(tokens[i])) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                int newInt = first * second;
                stack.add(newInt);
            }else if ("/".equals(tokens[i])) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                int newInt = first / second;
                stack.add(newInt);
            }else {
                Integer integer = Integer.valueOf(tokens[i]);
                stack.add(integer);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        T150 t150 = new T150();
        System.out.println(t150.evalRPN(new String[]{
                "2", "1", "+", "3", "*"
        }));
    }

}
