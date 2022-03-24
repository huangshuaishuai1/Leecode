package acwing;

import java.util.Scanner;

public class Acwing1714 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int c3 = scanner.nextInt();
        int m3 = scanner.nextInt();
        c1 -= m1;
        c2 -= m2;
        c3 -= m3;
        for (int i = 0; i < 33; i++) {
            if (c2 != 0) {
                if (m1 > c2) {
                    int[] ints = situation2(c1, m1, c2, m2);
                    c1 = ints[0];
                    m1 = ints[1];
                    c2 = ints[2];
                    m2 = ints[3];
                }else {
                    int[] ints = situation1(c1, m1, c2, m2);
                    c1 = ints[0];
                    m1 = ints[1];
                    c2 = ints[2];
                    m2 = ints[3];
                }
            }
            if (c3 != 0) {
                if (m2 > c3) {
                    int[] ints = situation2(c2, m2, c3, m3);
                    c2 = ints[0];
                    m2 = ints[1];
                    c3 = ints[2];
                    m3 = ints[3];
                }else {
                    int[] ints = situation1(c2, m2, c3, m3);
                    c2 = ints[0];
                    m2 = ints[1];
                    c3 = ints[2];
                    m3 = ints[3];
                }
            }
            if (c1 != 0) {
                if (m3 > c1) {
                    int[] ints = situation2(c3, m3, c1, m1);
                    c3 = ints[0];
                    m3 = ints[1];
                    c1 = ints[2];
                    m1 = ints[3];
                }else {
                    int[] ints = situation1(c3, m3, c1, m1);
                    c3 = ints[0];
                    m3 = ints[1];
                    c1 = ints[2];
                    m1 = ints[3];
                }
            }
        }
        if (c2 != 0) {
            if (m1 > c2) {
                int[] ints = situation2(c1, m1, c2, m2);
                c1 = ints[0];
                m1 = ints[1];
                c2 = ints[2];
                m2 = ints[3];
            }else {
                int[] ints = situation1(c1, m1, c2, m2);
                c1 = ints[0];
                m1 = ints[1];
                c2 = ints[2];
                m2 = ints[3];
            }
        }
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }

    // 情况一：倒奶的那个桶被倒完
    public static int[] situation1(int startSpace, int startMilk, int destinationSpace, int destinationMilk) {
        int startSpace1 = startSpace + startMilk;
        int destinationSpace1 = destinationSpace - startMilk;
        int destinationMilk1 = destinationMilk +  startMilk;
        int startMilk1 = 0;
        return new int[] {startSpace1, startMilk1, destinationSpace1, destinationMilk1};
    }
    // 情况二：接受的那个桶装满了
    public static int[] situation2(int startSpace, int startMilk, int destinationSpace, int destinationMilk) {
        int destinationMilk1 = destinationMilk + destinationSpace;
        int destinationSpace1 = 0;
        int startMilk1 = startMilk - destinationSpace;
        int startSpace1 = startSpace + destinationSpace;
        return new int[] {startSpace1, startMilk1, destinationSpace1, destinationMilk1};
    }

}
