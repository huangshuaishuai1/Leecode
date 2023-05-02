package niuke;

import java.util.*;

public class TX2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int target = scanner.nextInt();
        HashSet<String> set = new HashSet<>();
        PriorityQueue<String> strings = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < str.length()-i+1; j++) {
                String s = str.substring(j, j+i);
                if (!set.contains(s)) {
                    set.add(s);
                    if (strings.size() < target) {
                        strings.add(s);
                    } else {
                        if (s.compareTo(strings.peek()) < 0) {
                            strings.poll();
                            strings.add(s);
                        }
                    }
                }
            }
        }



        System.out.println(strings.peek());

    }

}
