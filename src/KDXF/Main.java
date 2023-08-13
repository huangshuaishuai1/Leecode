package KDXF;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < len; i++) {
            a.append(scanner.nextInt());
        }
        for (int i = 0; i < len; i++) {
            b.append(scanner.nextInt());
        }
        ArrayList<String> strings = new ArrayList<>();
        dfs(0,a,strings,new StringBuilder());
        dfs(0,b,strings,new StringBuilder());
        System.out.println(strings.size());
    }

    public static void dfs(int startIndex,  StringBuilder str, ArrayList<String> strings, StringBuilder stringBuilder) {
        if (stringBuilder.length() != 0 ) {
            String intern = new String(stringBuilder).intern();
            if (!strings.contains(intern)) {
                strings.add(intern);
            }
        }
        for (int i = startIndex; i < str.length(); i++) {
            int number = str.charAt(i);
            stringBuilder.append(number);
            dfs(i+1,str,strings,stringBuilder);
//            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder = new StringBuilder();
        }
    }
}
