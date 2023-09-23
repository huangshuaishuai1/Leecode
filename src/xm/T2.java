package xm;

import java.util.*;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        String[] split = str.split(",");
        int[][] task = new int[n][2];
        // 表示 任务 key 的直接前置任务，当所有前置任务完成后，就可以执行任务key
        HashMap<Integer, ArrayList<Integer>> before = new HashMap<>();
        // 表示任务key的后置任务，当完成任务key后，去before里面找到对应的key，并移除里面的value。
        HashMap<Integer, ArrayList<Integer>> after = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] split1 = split[i].split(":");
            task[i][0] = Integer.parseInt(split1[0]);
            task[i][1] = Integer.parseInt(split1[1]);
            ArrayList<Integer> list = before.getOrDefault(task[i][0], new ArrayList<>());
            list.add(task[i][1]);
            ArrayList<Integer> list2 = after.getOrDefault(task[i][1], new ArrayList<>());
            list2.add(task[i][0]);
            before.put(task[i][0],list);
            after.put(task[i][1],list2);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!before.containsKey(i)) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Integer poll = queue.poll();
                ArrayList<Integer> list = after.getOrDefault(poll, new ArrayList<>());
                after.remove(poll);
                for (Integer integer : list) {
                    ArrayList<Integer> list1 = before.get(integer);
                    list1.remove(list1.indexOf(poll));
                    if (list1.size() == 0) {
                        queue.add(integer);
                        before.remove(integer);
                    } else {
                        before.put(integer,list1);
                    }
                }
            }
        }
        if (before.size() == 0 && after.size() == 0) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }
}
