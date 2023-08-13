package KDXF;

import java.util.ArrayList;

public class T3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.m(3,new int[]{1,2,3},new int[]{2,3,1});
    }

    public void m(int len, int[] a, int[] b) {
        ArrayList<String> strings = new ArrayList<>();
        dfs(0,len,a,strings,new StringBuilder());
        dfs(0,len,b,strings,new StringBuilder());
        System.out.println(strings.size());
    }

    public void dfs(int startIndex, int len, int[] arr, ArrayList<String> strings,StringBuilder stringBuilder) {
        if (stringBuilder.length() != 0 ) {
            String intern = new String(stringBuilder).intern();
            if (!strings.contains(intern)) {
                strings.add(intern);
            }
        }
        for (int i = startIndex; i < len; i++) {
            int number = arr[i];
            stringBuilder.append(number);
            dfs(i+1,len,arr,strings,stringBuilder);
//            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder = new StringBuilder();
        }
    }
}
