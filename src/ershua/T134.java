package ershua;

public class T134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int[] gap = new int[5];
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            gap[i] = gas[i] - cost[i];
        }
        if(gasSum < costSum ) {
            return -1;
        }

        int now = 0;
        for (int i = 0; i < gas.length; i++) {
            now = 0;
            if( now == 0 && gap[i] < 0) {
                continue;
            }
            for(int j = 0; j < gas.length; j++) {
                now += gas[(i+j) % gas.length];
                now -= cost[(i+j) % gas.length];
                if (now < 0) {
                    break;
                }
            }
            if(now >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T134 t134 = new T134();
        System.out.println(t134.canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
    }
}
