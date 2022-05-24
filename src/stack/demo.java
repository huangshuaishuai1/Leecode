package stack;

import java.util.Enumeration;
import java.util.Stack;

public class demo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.peek());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());



    }
}
