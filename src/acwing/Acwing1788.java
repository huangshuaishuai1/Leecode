package acwing;

import java.util.HashMap;
import java.util.Scanner;

public class Acwing1788 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int id = scanner.nextInt();
            int side = scanner.nextInt();
            if (map.containsKey(id) && !map.get(id).equals(side)) {
                map.put(id, side);
                count++;
            } else {
                map.put(id,side);
            }
        }
        System.out.println(count);
    }
}
