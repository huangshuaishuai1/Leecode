package lanqiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class shuangxiangpaixv {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int t = scanner.nextInt();
        Integer[] array = new Integer[len];
        for(int i = 0 ; i < len; i++) {
            array[i] = i + 1;
        }
        int[][] sorts = new int[t][2];
        for (int i = 0; i < t; i++) {
            sorts[i][0] = scanner.nextInt();
            sorts[i][1] = scanner.nextInt();
        }

        for(int i = 0; i < t; i++) {
            if (sorts[i][0] == 0) {
                Arrays.sort(array,0,sorts[i][1],new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
            }else {
                Arrays.sort(array,sorts[i][1]-1,array.length);
            }
        }
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(" ");
            System.out.print(array[i]);
        }
    }
}
