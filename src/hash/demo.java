package hash;

import java.util.HashMap;

public class demo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1, 2);
        System.out.println(integerIntegerHashMap.toString());
        integerIntegerHashMap.put(1, 3);
        System.out.println(integerIntegerHashMap.toString());
    }
}
