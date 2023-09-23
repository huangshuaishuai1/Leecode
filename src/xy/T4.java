package xy;

public class T4 {
    /**
     * 兑换次数
     */
    static int count = 0;
    /**
     *  盖子数
     */
    static int cover = 0;
    public static void main(String[] args) {
        int ret = func(10);
        System.out.println(ret);
    }

    static int func(int n) {
        if (n + cover < 3) {
            return n;
        }
        // 先用盖子兑换
        cover+=n;
        int tmp = (cover) / 3;
        cover %= 3;
        // 再用次数兑换
        count += tmp;
        int tmp2 = count/3;
        count%=3;
        // 本轮一共喝现在的n瓶, 然后下一轮传参 tmp + tmp
        return n+func(tmp+tmp2);
    }

}
