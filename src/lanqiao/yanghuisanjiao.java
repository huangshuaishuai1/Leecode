package lanqiao;

import java.util.Scanner;

public class yanghuisanjiao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N == 1) {
            System.out.println(1);
        }else {
            yanghuisanjiao yanghuisanjiao = new yanghuisanjiao();
            System.out.println(yanghuisanjiao.helper(N,2,new int[]{1},0));
        }

    }

    int helper(int N, int loop, int[] array, int count) {
        int[] now = new int[loop];
        now[0] = 1;
        now[loop-1] = 1;
        count += 2;
        for (int i = 1; i < loop-1; i++) {
            now[i] = array[i-1] + array[i];
            count++;
            if (now[i] == N) {
                return count;
            }
        }
        return helper(N,loop+1,now,count);
    }
}
