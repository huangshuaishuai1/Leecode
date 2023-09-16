package sxf;

import java.util.ArrayList;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long l1 = scanner.nextLong();
        long ans = 1;
        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < l1; i++) {
            long tmp = ans * l;
            ans = tmp % 10;
            if (list.contains(ans)) {
                break;
            }
            list.add(ans);
        }

        System.out.println(list.get((int)l1%list.size())-1);

    }
}
