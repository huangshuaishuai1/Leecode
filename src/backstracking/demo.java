package backstracking;

import java.util.Collections;
import java.util.LinkedList;

public class demo {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("aaa");
        strings.add("ccc");
        strings.add("bbb");
        System.out.println(strings);
        Collections.sort(strings);
        System.out.println(strings);
    }
}
