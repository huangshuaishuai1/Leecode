package lambda;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2222);
        list.add(33);
        list.add(-1);
        list.sort((o1, o2) -> o1-o2);
        System.out.println(list);
    }
}
