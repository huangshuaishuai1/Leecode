package dewu;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        String str = scanner.next();

        for (int i = 0; i < n-x+1; i++) {
            int start = i;
            int end = i+x-1;
            while (start <= end) {
                if (str.charAt(start) != str.charAt(end)) {
                    break;
                }
                start++;
                end--;
            }
            if (start > end) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }


}
