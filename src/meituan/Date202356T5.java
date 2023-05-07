package meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class Date202356T5 {

    static int[] parent;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {

        }

    }
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x];
    }

    public static void union(int x,int y) {
        parent[find(y)] = parent[find(x)];
    }
}
