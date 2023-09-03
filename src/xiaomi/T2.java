package xiaomi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String[] tasks = str.split(",");
        int[][] resource = new int[tasks.length][2];
        int len = 0;
        for (String task : tasks) {
            String[] split = task.split(":");
            resource[len][0] = Integer.valueOf(split[0]);
            resource[len][1] = Integer.valueOf(split[1]);
            len++;
        }
        Arrays.sort(resource, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int batteryCapacity = 0;
        for (int i = 0; i < resource.length; i++) {
            int requiredBattery = resource[i][1];
            if (requiredBattery > batteryCapacity) {
                // 如果当前任务所需电量大于当前电量，更新电量为所需电量
                batteryCapacity = requiredBattery;
            } else {
                // 否则，减去当前任务的耗电量
                batteryCapacity -= resource[i][0];
            }

            if (batteryCapacity < 0) {
                // 如果电量不足，返回-1
                System.out.println(-1);
            }
        }
        System.out.println(batteryCapacity);
    }
}
