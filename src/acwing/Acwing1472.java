package acwing;

import java.util.Scanner;

public class Acwing1472 {
    public static void main(String[] args) {
        char[][] input = new char[10][10];
        Scanner scanner = new Scanner(System.in);
        int ib = 0, jb =0, ir = 0, jr = 0, il = 0, jl = 0;
        for (int i = 0; i < 10; i++) {
            char temp[] = scanner.nextLine().toCharArray();
            for (int j = 0; j < 10; j++) {
                if (temp[j] == 'B') {
                    ib = i;
                    jb = j;
                }else if (temp[j] == 'R') {
                    ir = i;
                    jr = j;
                }else if (temp[j] == 'L') {
                    il = i;
                    jl = j;
                }
            }
        }
        if ((il == ib) && (il == ir) && ((jr>jl) && (jr<jb) || (jr<jl) && (jr>jb))
                || (jl == jb) && (jl == jr) && ((ir>il) && (ir<ib) || (ir<il) && (ir>ib))) {
            System.out.println(Math.abs(il-ib) + Math.abs(jl-jb) + 1);
        }else {
            System.out.println(Math.abs(il-ib) + Math.abs(jl-jb) - 1);
        }
    }
}
