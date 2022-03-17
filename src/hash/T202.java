package hash;

import java.util.HashSet;

public class T202 {
    public static void main(String[] args) {
        T202 t202 = new T202();
        boolean happy = t202.isHappy(2);
        System.out.println(happy);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();
        int sum = happySum(n);
        while (sum != 1) {
            if (!integers.add(sum)) {
                return false;
            }
            sum = happySum(sum);
        }
        return true;
    }

    public int happySum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
