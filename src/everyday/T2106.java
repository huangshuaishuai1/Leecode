package everyday;

public class T2106 {
    public static void main(String[] args) {
        T2106 t2106 = new T2106();
        int[][] fruits = new int[1][2];
        fruits[0] = new int[]{0,1000};
//        fruits[1] = new int[]{6,3};
//        fruits[2] = new int[]{8,6};
//        fruits[3] = new int[]{6,2};
//        fruits[4] = new int[]{7,4};
//        fruits[5] = new int[]{10,9};
        int i = t2106.maxTotalFruits(fruits, 20000, 20000);
        System.out.println(i);
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int a = Math.max(startPos - k,0);

        int ret = 0;
        int max = 0;
        int first = -1;
        int num = 0;
        for (int i = 0; i < fruits.length ; i++) {
            if (fruits[i][0] < a) {
                continue;
            }
            first = fruits[i][0];
            num = i;
            break;
        }
        if (first == -1) {
            return 0;
        }
        for (int i = num; i < fruits.length; i++) {
            ret = 0;
            if (fruits[i][0] >= startPos) {
                for (int j = i; j < fruits.length; j++) {
                    if (fruits[j][0] <= startPos + k) {
                        ret += fruits[j][1];
                    }else {
                        max = Math.max(max,ret);
                        break;
                    }
                }
                max = Math.max(max,ret);
                break;
            }
            // 先得到该起始点
            first = fruits[i][0];
            // 看pos离这个点多远
            int gap = startPos - first;
            // 当gap 小于等于 二分之k 那么就先走左边再拐回去
            if (gap <= k/2) {
                int nowK = k - 2*gap;
                for (int j = num; j < fruits.length; j++) {
                    if (fruits[j][0] <= startPos + nowK) {
                        ret += fruits[j][1];
                    }else {
                        max = Math.max(max,ret);
                        break;
                    }
                }
            }else {
                gap = k - gap;
                gap /= 2;
                // gap 表示可以再往右走gap个位置
                for (int j = num; j < fruits.length; j++) {
                    if (fruits[j][0] <= startPos) {
                        ret += fruits[j][1];
                    }else if (fruits[j][0] <= startPos+gap) {
                        ret += fruits[j][1];

                    }else {
                        max = Math.max(max,ret);
                        break;
                    }
                    max = Math.max(max,ret);
                }
            }
        }
        return max;
    }
}
