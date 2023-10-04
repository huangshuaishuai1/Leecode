package lambda;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;

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

        func1((num) -> {
            System.out.println(num);
        });
        String s = func2((str) -> String.valueOf(str));
        System.out.println(s);
    }

    public static void func1(Consumer<Integer> consumer) {
        consumer.accept(11);
    }

    public static String func2(Function<Integer,String> function) {
        return function.apply(111);
    }
}
