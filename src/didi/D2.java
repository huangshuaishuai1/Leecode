package didi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class D2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String tmp = strings[i] + strings[j];
                StringBuilder stringBuilder = new StringBuilder(tmp);
                stringBuilder.deleteCharAt(0);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                tmp = new String(stringBuilder);
                for (int k = 0; k < n; k++) {
                    if (tmp.contains(strings[k]) && !ans.contains(strings[k])) {
                        ans.add(strings[k]);
                    }
                }
            }
        }
        ans.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(ans.size());
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
