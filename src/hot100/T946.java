package hot100;
import java.util.*;
public class T946 {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public static  boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIdx = 0;
        for(int i = 0; i < popped.length; i++) {
            int now = popped[i];
            if(stack.contains(now) ) {
                if (stack.peek() != now)
                    return false;
                else
                    stack.pop();
            } else {
                while(pushIdx < pushed.length) {
                    if(pushed[pushIdx] == now) {
                        pushIdx++;
                        break;
                    }
                    stack.push(pushed[pushIdx]);
                    pushIdx++;
                }
            }

        }
        return true;


    }
}
