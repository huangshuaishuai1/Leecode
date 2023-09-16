package linkedlist;

import dxm.TTT;

public class TTTT {

    public static void main(String[] args) {
        TTTT ttt = new TTTT();
        System.out.println(ttt.find(5, 4, new int[]{1, 2, 4, 4, 5}));
    }

    public int find (int n, int v, int[] a) {
        // write code here

        if (v > a[n-1]) {
            return n+1;
        }

        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = n-1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (a[mid] >= v) {
                ans = Math.min(ans,mid+1);
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
