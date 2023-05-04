package qianzhuihe;

public class T1732 {
    public int largestAltitude(int[] gain) {
        int max = gain[0];
        int now = max;
        for (int i = 1; i < gain.length; i++) {
            now = now + gain[i];
            max = Math.max(max,now);
        }
        return max;
    }
}
