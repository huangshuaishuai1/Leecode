package greedy;

public class T738 {

    public int monotoneIncreasingDigits(int n) {
        int[] pos = new int[10];
        int num = n;
        for (int i = 0; i < 10; i++) {
            int a = num % 10;
            pos[pos.length-1-i] = a;
            num = num / 10;
        }
        int ret = 0;
        int startIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (pos[i] != 0) {
                startIndex = i;
                break;
            }
        }
        int nowNum = pos[9];
        for (int i = 8; i >= startIndex; i--) {
            if (nowNum < pos[i]) {
                for (int j = i+1; j < 10; j++) {
                    pos[j] = 9;
                }
                pos[i]--;
            }
            nowNum = pos[i];
        }
        for (int i = startIndex; i < 10; i++) {
            ret*=10;
            ret+=pos[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        T738 t738 = new T738();
        int i = t738.monotoneIncreasingDigits(1000);
        System.out.println("i = " + i);
    }
}
