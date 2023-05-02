package lanqiao;

import java.util.Scanner;

public class shijianxianshi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long i = scanner.nextLong();
        long totle = i % 1000;
        totle = i - totle;
        totle = totle % 86400000;
        long h = totle / 3600000;
        totle %= 3600000;
        long m = totle / 60000;
        totle %= 60000;
        long s = totle / 1000;
        StringBuilder sb = new StringBuilder();
        if (h < 10) {
            sb.append(0);
        }
        sb.append(h);
        sb.append(":");
        if (m < 10) {
            sb.append(0);
        }
        sb.append(m);
        sb.append(":");
        if (s < 10) {
            sb.append(0);
        }
        sb.append(s);
        System.out.println(sb);
    }
}
