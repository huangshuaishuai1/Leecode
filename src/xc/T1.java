package xc;

import java.util.ArrayList;
import java.util.Scanner;

public class T1 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] used = new int[n];
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> aaa = new ArrayList<ArrayList<Integer>>();
        backStracking(used,a, n,aaa );
        System.out.println(T1.ans);
    }

    public static void backStracking(int[] used, ArrayList<Integer> arr, int n, ArrayList<ArrayList<Integer>> aaa) {
        if (arr.size() == n) {
            aaa.add(new ArrayList<>(arr));
            ans++;
        }

        for (int i = 0; i < n; i++) {
            if (used[i] == 1) {
                continue;
            }
            int sz = arr.size();
            if (sz > 0 && !valid(arr.get(sz-1) + i + 1)) {
                continue;
            }
            used[i] = 1;
            arr.add(i+1);
            backStracking(used,arr,n,aaa);
            arr.remove(arr.size()-1);
            used[i] = 0;
        }
    }
    public static boolean valid(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
