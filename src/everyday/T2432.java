package everyday;

import java.util.HashMap;

public class T2432 {


    public int hardestWorker(int n, int[][] logs) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < logs.length; i++) {
            end = logs[i][1];
            int emp = logs[i][0];
            if (max < end-start) {
                max = Math.max(max,end-start);
                ans = emp;
            }else if(max == end-start) {
                if(ans > emp) {
                    ans = emp;
                }
            }
            start=end;
        }
        return ans;
    }
}