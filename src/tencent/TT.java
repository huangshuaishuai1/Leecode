package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class TT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] happy = new int[n];
        for (int i = 0; i < n; i++) {
            happy[i] = scanner.nextInt();
        }
        Arrays.sort(happy);

        if (happy[0] > 0) {
            System.out.println(Arrays.stream(happy).sum() + happy.length / 3 * k);
            return;
        }

        int right = n-1;
        int ans = 0;
        int count = 0;
        while (right >= 0 && happy[right] > 0) {
            ans+=happy[right];
            count+=1;
            right--;
        }
        ans += (count/3)*k;
        count%=3;
        while (right >= 2 && happy[right] > -k) {
            if (happy[right] + happy[right-1] + happy[right-2] > -k) {
                ans += happy[right] + happy[right-1] + happy[right-2] + k;
            }else {
                break;
            }
            right-=3;
        }

        if (count == 2 && right >= 0) {
            if (happy[right] > -k) {
                ans += happy[right] + k;
            }
            right--;
        }else if (count == 1 && right >= 1) {
            if (happy[right] + happy[right-1] > -k) {
                ans += happy[right] + happy[right-1] + k;
            }
            right-=2;
        }
        System.out.println(ans);
    }
}
