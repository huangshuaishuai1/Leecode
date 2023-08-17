package elm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (!list.contains(str.charAt(i))) {

                list.add(str.charAt(i));
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (list.indexOf(str.charAt(i)) == list.size()-1) {
                sb.append(list.get(0));
            }else {
                sb.append(list.get(list.indexOf(str.charAt(i))+1));
            }
        }
        System.out.println(sb);
    }
}
