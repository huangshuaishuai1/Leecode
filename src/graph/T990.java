package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class T990 {
    public static void main(String[] args) {
        T990 t990 = new T990();
        System.out.println(t990.equationsPossible(new String[]{"c==c","b==d","x!=z"}));
    }

    public boolean equationsPossible(String[] equations) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if (equation.charAt(1) == '=') {
                union(parent,equation.charAt(0)-'a',equation.charAt(3)-'a');
            } else {
                arrayList.add(i);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            String equation = equations[arrayList.get(i)];
            if (findParent(parent,equation.charAt(0)-'a') == findParent(parent, equation.charAt(3)-'a')) {
                return false;
            }
        }
        return true;
    }

    void union(int[] parent, int a, int b) {
        int aP = findParent(parent,a);
        int bP = findParent(parent,b);

        if (aP > bP) {
            parent[aP] = bP;
        }else {
            parent[bP] = aP;
        }
    }
    int findParent(int[] parent, int a) {
        if (parent[a] == a) {
            return a;
        }

        return findParent(parent,parent[a]);
    }
}
