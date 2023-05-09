package dp;

import java.util.ArrayList;
import java.util.List;

public class T118 {
    public static void main(String[] args) {
        T118 t118 = new T118();
        List<List<Integer>> generate = t118.generate(4);
        System.out.println(111);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        ans.add(new ArrayList<>(tmp));
        if (numRows == 1) {
            return ans;
        }
        tmp.add(1);
        ans.add(new ArrayList<>(tmp));
        if (numRows == 2) {
            return ans;
        }
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            ArrayList<Integer> list1 = (ArrayList<Integer>) ans.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(list1.get(j-1) + list1.get(j));
            }
            list.add(1);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

}
