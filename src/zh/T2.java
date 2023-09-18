package zh;

import java.util.Arrays;

public class T2 {

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    public int findContentChildren (int[] childrens, int[] breads) {
        // write code here
        Arrays.sort(childrens);
        Arrays.sort(breads);
        int count = 0;
        for (int i = 0; i < breads.length; i++) {
            if (count < childrens.length && breads[i] >= childrens[count]) {
                count++;
                continue;
            }
        }
        return count;
    }
}
