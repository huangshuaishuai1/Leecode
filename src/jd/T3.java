package jd;

import java.util.*;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int freq = scanner.nextInt();
        String freqLoss = scanner.next();
        Map<Integer, Integer> freqs = new HashMap<>();
        String[] freqLossParts = freqLoss.split(",");
        int distance = Integer.MAX_VALUE;

        for (String part : freqLossParts) {
            String[] subParts = part.split(":");
            int curN = Integer.parseInt(subParts[0]);
            int curLoss = Integer.parseInt(subParts[1]);
            distance = Math.min(distance, Math.abs(freq - curN));
            freqs.put(curN, curLoss);
        }

        double ret = 0;

        if (distance == 0) {
            ret = freqs.get(freq);
        } else {
            int pre = freq - distance;
            int back = freq + distance;
            int cnt = 0;

            for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
                if (entry.getKey() == pre) {
                    ret += entry.getValue();
                    cnt++;
                } else if (entry.getKey() == back) {
                    ret += entry.getValue();
                    cnt++;
                    break;
                }
            }

            ret /= cnt;
        }

        System.out.printf("%.1f\n", ret);
    }
}
