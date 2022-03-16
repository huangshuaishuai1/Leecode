package linkedlist;
import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Integer pop = stack.pop();
        System.out.println(pop);
    }


}
