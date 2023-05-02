package weizhong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int bug = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] number = new int[row];
        int[] counts = new int[row];
        for (int i = 0; i < row; i++) {
            number[i] = scanner.nextInt();
            map.put(number[i],0);
            counts[i] = scanner.nextInt();
        }

        int offset = 0;
        if (counts[0] / bug <= 1) {
            map.put(number[0],map.get(number[0]) + counts[0]);
            offset = counts[0];
        }else {
            map.put(number[0],(counts[0] / bug) * 2 * bug + (counts[0] % bug));
            offset = counts[0] % bug;
        }
        for (int i = 1; i < row; i++) {
            if (number[i] != number[i-1]) {
                offset = 0;
            }
            if ((counts[i] + offset) % bug != 0) {
                map.put(number[i], (map.get(number[i])+((counts[i] + offset) / bug) * bug + counts[i]));
                offset = (counts[i] + offset) % bug;
            }else {
                map.put(number[i], (map.get(number[i])+((counts[i] + offset) / bug - 1) * bug + counts[i]));
                offset = bug;
            }
        }
        Arrays.sort(number);
        System.out.println(map.size());
        for (int i = 0; i < number.length; i++) {
            if (i == 0 || number[i] != number[i-1]) {
                System.out.println(number[i] + " " + map.get(number[i]));
            }
        }
    }
}
