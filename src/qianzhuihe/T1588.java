package qianzhuihe;

public class T1588 {

    public static void main(String[] args) {
        T1588 t1588 = new T1588();
        System.out.println(t1588.sumOddLengthSubarrays(new int[]{1, 2}));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int sum = 0;
        int ret = 0;
        for (int i = 1; i <= len; i+=2) {
            ret = 0;
            for (int j = 0; j < i; j++) {
                ret += arr[j];
            }
            sum += ret;
            for (int j = 1; j <= len-i; j++) {
                ret-=arr[j-1];
                ret+=arr[j+i-1];
                sum+=ret;
            }
        }
        return sum;
    }
}
