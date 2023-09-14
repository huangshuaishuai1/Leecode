package mayi;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Scanner;

public class T11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int h = scanner.nextInt();
            // 先加血
            if (b >= 3) {
                if (b > 5) {
                    a = Math.max(0,a-x);
                    h -= a*b;
                    if (x-a > 0) {
                        h+=Math.min(y,x-a)*5;
                    }
                } else {
                    h += Math.min(x,y) * 5;
                    x -= Math.min(x,y);
                    a-=x;
                    h-=(Math.max(0,a)*b);
                }

            }else {
                // 先挨打
                if (a < x) {
                    h += Math.min(x,y)*5;
                }else {
                    if (b == 1){
                        if (a < 2*x) {
                            h += Math.min(x,y)*5;
                        } else {
                            int remain = Math.max(0,3*x-a);
                            h += Math.min(Math.min(x,y),remain)*5;
                            if (a-3*x > 0) {
                                h-=(a-3*x)*b;
                            }
                        }
                    }else if (b==2){
                        int remain = Math.max(0,2*x-a);
                        h += Math.min(Math.min(x,y),remain)*5;
                        if (a - 2*x > 0) {
                            h-=(a - 2*x ) * b;
                        }
                    }
                }
            }
            if (h > 0) {
                System.out.println(h);
            } else {
                System.out.println("kou dead.");
            }
        }
    }
}
