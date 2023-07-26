package graph;

public class T1061 {

    public static void main(String[] args) {
        T1061 t1061 = new T1061();
        System.out.println(t1061.smallestEquivalentString("parker", "morris", "parser"));
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        // 初始化
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            union(parent,s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            stringBuilder.append((char)('a'+ findParent(parent,baseStr.charAt(i)-'a')));
        }
        return new String(stringBuilder);
    }

    void union(int[] parent, int a, int b) {
        int aP = findParent(parent, a);
        int bP = findParent(parent, b);
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
