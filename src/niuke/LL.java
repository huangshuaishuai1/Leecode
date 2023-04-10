package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LL {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        char[] array = number.toCharArray();
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        int[] used = new int[number.length()];
        backStracking(list,array,characters,used);
//        int a = '1';
//        System.out.println(a-48);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    private static void backStracking(ArrayList<Integer> list, char[] array, ArrayList<Character> characters, int[] used) {
        if (characters.size()==2) {
            int tmp =( characters.get(0)-48) * 10 + (characters.get(1)-48);
//            if (!list.contains(tmp)) {
                list.add(tmp);
//            }
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i-1] && used[i-1] == 0) {
                continue;
            }
            if (characters.size() == 0 && array[i] == '0') {
                continue;
            }
            if (used[i] != 1) {
                characters.add(array[i]);
                used[i] = 1;
                backStracking(list,array,characters,used);
                used[i]=0;
                characters.remove(characters.size()-1);
            }
        }
    }


}
