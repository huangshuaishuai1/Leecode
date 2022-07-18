package greedy;

public class T134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tag = gas.length-1;
        int sum = 0;

        for (int i = gas.length-1; i >=0 ; i--) {
            if(gas[i] <= cost[i]) {
                sum+=gas[i]-cost[i];
            }else if (gas[i] - cost[i] >= -sum) {
                tag = i;
                sum = 0;
            }else {
                sum+=gas[i]-cost[i];
            }
        }
        sum = 0;
        for (int i = 0; i < gas.length; i++) {
            if (i!=tag) {
                sum += gas[i] - cost[i];
            }

        }
        if (gas[tag] - cost[tag] + sum >= 0) {
            return tag;
        }
        return -1;
    }

    public static void main(String[] args) {
        T134 t134 = new T134();
        System.out.println(t134.canCompleteCircuit(new int[]{2,0,1,2,3,4,0},new int[] {0,1,0,0,0,0,11}));
    }
}
