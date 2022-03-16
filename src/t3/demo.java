package t3;

import java.util.HashMap;

public class demo {


    public static void main(String[] args) {
        Counter2 counter = new Counter2();
        Counter2 counter2 = (Counter2) counter.clone();
        counter.add('a',1);
        System.out.println(counter.get('a'));
        System.out.println(counter2.get('a'));
    }

}

class Counter2 extends HashMap<Character, Integer> {
    public int get(Character key) {
        return containsKey(key)? super.get(key) : 0;
    }

    public void add (Character key, Integer value) {
        put(key, get(key) + value);
    }
}
