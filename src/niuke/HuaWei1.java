package niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class HuaWei1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            int a = in.nextInt();
            if (a!=0) {
                list.add(a);
            }else {
                break;
            }
        }
        for (Integer number : list) {
            int count = 0;
            while (number > 0) {
                if (number == 1) {
                    System.out.println(count);
                    break;
                }else if (number==2){
                    System.out.println(count+1);
                    break;
                }
                int drink = number / 3;
                count+=drink;
                number -= drink * 2;
            }
        }
    }


}
