package jd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int money = scanner.nextInt();
            int discount = scanner.nextInt();
            Integer orDefault = map.getOrDefault(money, 0);
            int max = Math.max(orDefault,discount);
            map.put(money,max);
        }
        int cost = 0;
        int[] key = new int[map.size()];
        Object[] array = map.keySet().toArray();
        for (int i = 0; i < array.length; i++) {
            key[i] = (int) array[i];
        }
        Arrays.sort(key);
        for (int i = 0; i < prices.length; i++) {
            int money = prices[i];
            int pay = money;
            for (int j = money; j > money - pay; j--) {
                if (map.containsKey(j)) {
                    int tmp = money - map.get(j);
                    pay = Math.min(pay,tmp);
                }
            }
            cost += pay;
        }
        System.out.println(cost);
    }
}
