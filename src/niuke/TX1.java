package niuke;
import java.util.Scanner;


class Heler {

    int[] parent;
    int[] parentPersonNum;
    int max;
    public Heler() {
        parent = new int[100001];
        parentPersonNum = new int[100001];
        for (int i = 1; i < 100001; i++) {
            parent[i] = i;
            parentPersonNum[i] = 1;
        }
        max = 0;
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) {
        int parent_x = find(x);
        int parent_y = find(y);

        parent[parent_x] = parent_y;
        parentPersonNum[parent_y] += parentPersonNum[parent_x];
        max = Math.max(max,parentPersonNum[parent_y]);
    }

}


public class TX1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        int[] ret = new int[loop];
        for (int i = 0; i < loop; i++) {
            int max = 0;
            Heler heler = new Heler();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                heler.union(a,b);
            }
            ret[i] = heler.max;
        }
        for (int i = 0; i < loop; i++) {
            System.out.println(ret[i]);
        }
    }
}
