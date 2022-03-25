package str;

public class T541 {

    public String reverseStr(String s, int k) {
        int l = 0;
        int r = 0;
        int times = s.length() / (2*k);
        int remain = s.length() % (2 * k);
        char[] ret = s.toCharArray();
        for (int i = 0; i < times; i++) {
            // 先进行反转
            r = l + k - 1;
            int temp = l;
            while(l < r) {
                char c = ret[l];
                ret[l] = ret[r];
                ret[r] = c;
                l++;
                r--;
            }
            // 反转完成, 左指针跳到下一个周期的开始
            l = temp + 2 * k ;
        }
        // 处理余数
        if (remain > 1) {
            if (remain <= k) {
                r = s.length() - 1;
            }
            else {
                r = l + k - 1;
            }
            while (l < r) {
                char c = ret[l];
                ret[l] = ret[r];
                ret[r] = c;
                l++;
                r--;
            }
        }
        return new String(ret);
    }

    public static void main(String[] args) {
        T541 t541 = new T541();
        String abcdefg = t541.reverseStr("abcdef", 5);
        System.out.println(abcdefg);
    }

}
