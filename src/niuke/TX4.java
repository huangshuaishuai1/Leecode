package niuke;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TX4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String sloop = in.nextLine();
        int loop = Integer.parseInt(sloop);
        for (int i = 0; i < loop; i++) {
            String sn = in.nextLine();
            int n = Integer.parseInt(sn);
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                String next = in.nextLine();
                String[] s = next.split(" ");
                if (s.length == 2) {
                    int num = Integer.parseInt(s[1]);
                    queue.add(num);
                }else if (s[0].equals("TOP")) {
                    System.out.println(queue.peek());
                }else if (s[0].equals("POP")) {
                    if (queue.size()==0) {
                        System.out.println(-1);
                    }else {
                        queue.poll();
                    }
                }else if (s[0].equals("SIZE")) {
                    System.out.println(queue.size());
                }else if (s[0].equals("CLEAR")) {
                    queue.clear();
                }
            }
        }
    }
}
