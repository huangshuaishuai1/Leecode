package acwing;

import java.util.HashMap;
import java.util.Scanner;

public class Acwing1442 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i,scanner.next());
        }
        int star = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (count + map.get(i).length() > K) {
                System.out.print(map.get(star));
                for (int j = star + 1; j < i; j++) {
                    System.out.print(" " + map.get(j));
                }
                System.out.println();
                star = i;
                count = 0;
                i--;
                continue;
            }else if (i == N - 1) {
                System.out.print(map.get(star));
                for (int j = star + 1; j <= i; j++) {
                    System.out.print(" " + map.get(j));
                }
            }else if (count + map.get(i).length() == K) {
                System.out.print(map.get(star));
                for (int j = star+1; j <= i; j++) {
                    System.out.print(" " + map.get(j));
                }
                System.out.println();
                star = i + 1;
                count = 0;
                continue;
            }
            count += map.get(i).length();
        }
    }
}
