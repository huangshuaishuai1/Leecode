package mt;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                List<Integer> list = map.getOrDefault(c, new ArrayList<>());
                list.add(i);
                map.put(c,list);
            }
        }
        if (n < 7) {
            System.out.println("NO");
            return;
        }
        if (!map.containsKey('m') || !map.containsKey('e') ||
                !map.containsKey('i') || !map.containsKey('t') || !map.containsKey('u')
        || !map.containsKey('a') || !map.containsKey('n')) {
            System.out.println("NO");
            return;
        }
        int now = -1;
        List<Integer> list = map.get('m');
        int finalNow = now;
        List<Integer> collect = list.stream().filter(integer -> integer > finalNow).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("NO");
            return;
        }
        Integer index = collect.get(0);
        if (index >  n-7) {
            System.out.println("NO");
            return;
        }
        now = index;
        list= map.get('e');
        int finalNow1 = now;
        collect = list.stream().filter(integer -> integer > finalNow1).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("NO");
            return;
        }
        index = collect.get(0);
        if (index > n-6) {
            System.out.println("NO");
            return;
        }
        now = index;
        list= map.get('i');
        int finalNow2 = now;
        collect = list.stream().filter(integer -> integer > finalNow2).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("NO");
            return;
        }
        index = collect.get(0);
        if (index > n-5) {
            System.out.println("NO");
            return;
        }
        now = index;
        list= map.get('t');
        int finalNow3 = now;
        collect = list.stream().filter(integer -> integer > finalNow3).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("NO");
            return;
        }
        index = collect.get(0);
        if (index > n-4) {
            System.out.println("NO");
            return;
        }

        now=index;
        list= map.get('u');
        int finalNow4 = now;
        collect = list.stream().filter(integer -> integer > finalNow4).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("NO");
            return;
        }
        index = collect.get(0);
        if (index > n-3) {
            System.out.println("NO");
            return;
        }

        now=index;
        list= map.get('a');
        int finalNow5 = now;
        collect = list.stream().filter(integer -> integer > finalNow5).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("NO");
            return;
        }
        index = collect.get(0);
        if (index > n-2) {
            System.out.println("NO");
            return;
        }

        now=index;
        list= map.get('n');
        int finalNow6 = now;
        collect = list.stream().filter(integer -> integer > finalNow6).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("NO");
            return;
        }
        index = collect.get(0);
        if (index > n-1) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
