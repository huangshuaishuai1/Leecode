package dp;

import java.util.ArrayList;
import java.util.List;

public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>(1);
        list.add(triangle.get(0).get(0));
        dp.add(list);
        // 开始循环
        for (int j = 1; j < triangle.size(); j ++) {
            List<Integer> integers = triangle.get(j);
            ArrayList<Integer> list1 = new ArrayList<>(integers.size());
            List<Integer> last = dp.get(j - 1);
            for (int i = 0; i < integers.size(); i++) {
                if (i == 0) {
                    list1.add(last.get(0) + integers.get(0));
                }else if (i == integers.size()-1){
                    list1.add(integers.get(i)+last.get(i-1));
                }
                else {
                    list1.add(integers.get(i)+Math.min(last.get(i),last.get(i-1)));
                }
            }
            dp.add(list1);
        }

        ArrayList<Integer> arrayList = dp.get(dp.size() - 1);
        for (Integer integer : arrayList) {
            ans = Math.min(ans,integer);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        arrayLists.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        arrayLists.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        arrayLists.add(list3);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        arrayLists.add(list4);
        T120 t120 = new T120();
        int i = t120.minimumTotal(arrayLists);
        System.out.println(i);
    }
}
