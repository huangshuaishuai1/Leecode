package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class demo2 {

    static final int max = 10001;
    static HashMap<Integer,ArrayList<Integer>> edges = new HashMap<>();
    static int blocks[] =new int[max];
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[] used = new int[max];
    static int maxDeep = max;

    static void backStracking(int index, ArrayList<Integer> list, int deep) {
        int nIndex = 0;
        boolean tag = false;
        for (int i = 0; i < edges.get(index).size(); i++) {
            nIndex = edges.get(index).get(i);
            if (used[nIndex] == 0) {
                tag = true;
                if (blocks[nIndex] == 0) {
                    used[nIndex] = 1;
                    list.add(nIndex);
                    backStracking(nIndex,list,deep+1);
                    list.remove(list.size()-1);
                    used[nIndex] = 0;
                }
            }
        }
        if (! tag) {
            if (deep < maxDeep) {
                maxDeep = deep;
                ans = new ArrayList<>(list);
            }
            else if (deep == maxDeep) {
                for (int i = 0; i < ans.size(); i++) {
                    if (list.get(i) < ans.get(i)) {
                        ans = new ArrayList<>(list);
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int l;
        int r;
        for (int i = 0; i < 10001; i++) {
            edges.put(i,new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            edges.get(l).add(r);
            edges.get(r).add(l);
        }
        for (int i = 0; i < max; i++) {
            blocks[i] = 0;
        }
        int b = scanner.nextInt();
        int t = 0;
        for (int i = 0; i < b; i++) {
            t = scanner.nextInt();
            blocks[t] = 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            used[i] = 0;
        }
        used[0] = 1;
        list.add(0);

        backStracking(0,list,0);
        if (maxDeep == max) {
            System.out.println("NULL");
        }else {
            for (int i = 0; i < ans.size(); i++) {
                if (i == 0) {
                    System.out.print(ans.get(i));
                }else {
                    System.out.print("->");
                    System.out.print(ans.get(i));
                }
            }
        }
    }
}
