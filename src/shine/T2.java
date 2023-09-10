package shine;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] split = str.split(",");
        str = split[0];
        int row = Integer.valueOf(split[1]);

        if (row == 1 || row >= str.length()) {
            System.out.println(str);
        }

        StringBuilder[] stringBuilders = new StringBuilder[row];
        for (int i = 0; i < row; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int x = 0;
        int t  = row * 2 - 2;
        for (int i = 0; i < str.length(); i++) {
            stringBuilders[x].append(str.charAt(i));
            if (i % t < row - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            sb.append(stringBuilder);
        }
        System.out.println(sb);

    }
}
