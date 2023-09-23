package wy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }

        int count  = sountSimilarPairs(strings);

        System.out.println(count);
    }

    private static int sountSimilarPairs(String[] strings) {

        int count  = 0;
        Map<String,Integer> frequencyMap = new HashMap<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);

            String sortedStr = new String(chars);

            frequencyMap.put(sortedStr,frequencyMap.getOrDefault(sortedStr,0)+1);
        }

        for (Integer value : frequencyMap.values()) {
            count+=value*(value-1)/2;
        }
        return count;
    }
}
