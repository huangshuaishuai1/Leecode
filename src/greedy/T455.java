package greedy;


import java.util.Arrays;

public class T455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count  = 0;
        for (int i = 0; i < s.length; i++) {
            if (count == g.length) {
                break;
            }
            if (s[i] >= g[count]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2,3};
        T455 t455 = new T455();
        int contentChildren = t455.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
