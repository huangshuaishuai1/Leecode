package tencent;

import java.util.*;

public class T5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int ans = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            ans += tmp;
            String s = Integer.toBinaryString(tmp);
            List<Integer> llist = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                int t = Integer.parseInt(s.charAt(s.length()-j-1)+"");
                if (t == 1) {
                    llist.add(j);
                }
            }
            list.add(llist);
        }
        int max = Integer.MIN_VALUE;
        for (List<Integer> aaaa : list) {
            if (aaaa.size() < k) {
                continue;
            }
            int ssum = 0;
            for (int i = 0; i < k; i++) {
                ssum += Math.pow(2,aaaa.get(i));
            }
            max = Math.max(max,ssum);
        }

        System.out.println(ans-max);
    }
}
