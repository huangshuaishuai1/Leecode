package acwing;
import java.util.Scanner;
public class baidu2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int z = input.nextInt();
        StringBuilder sb = new StringBuilder();

        // 构造字符串
        if (z == 0) {
            sb.append("r");
        } else {
            for (int i = 0; i < z / 2; i++) {
                sb.append("red");
            }
            if (z % 2 == 1) {
                sb.append("r");
            }
        }

        System.out.println(sb.toString());
    }
}


