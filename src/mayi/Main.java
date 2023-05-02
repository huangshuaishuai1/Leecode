package mayi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> primes = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> flags = new HashMap<>();
        for (int i = 2; i < n; i++) {
            if (!map.containsKey(i)) {
                primes.add(i);
                flags.put(i, 1);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) <= n; j++) {
                map.put(i * primes.get(j), 1);
                if (i % primes.get(j) == 0)
                    break;
            }
        }
        for (int i = primes.size() - 1; i >= 0; i--) {
            int cur = primes.get(i);
            for (int j = 0; j < i; j++) {
                if (flags.containsKey(cur - primes.get(j))) {
                    System.out.println(primes.get(j) + " " + (cur - primes.get(j)));
                    return;
                }
            }
        }
        System.out.println("-1");
    }
}
