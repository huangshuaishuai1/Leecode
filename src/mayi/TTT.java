package mayi;

import java.util.ArrayList;
import java.util.Scanner;

public class TTT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (i*i <= n) {
                list.add(i*i);
            }else {
                break;
            }
        }
        int ans = 0;
        int tmp[] = {0,list.size()-1};
        while (n > 0) {
            tmp = find(n, list, 0, tmp[1]);
            n-=tmp[0];
            ans += 4 * Math.sqrt(tmp[0]);
        }

        System.out.println(ans);
    }

    static int[] find(int target, ArrayList<Integer> list, int l, int r) {
        int idx = (l + r) / 2;
        if ((list.get(idx) < target && idx == r) || list.get(idx) == target) {
            return new int[]{list.get(idx),idx};
        }
        if (idx + 1 < list.size() && list.get(idx+1) < target) {
            l = idx+1;
            return find(target,list,l,r);
        }else {
            r = idx;
            return find(target,list,l,r);
        }
    }
}
