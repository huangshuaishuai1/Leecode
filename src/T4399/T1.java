package T4399;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        ArrayList<int[]> ints = new ArrayList<>();
        ints.add(new int[]{1,3});
        ints.add(new int[]{2,6});
        ints.add(new int[]{8,10});
        ints.add(new int[]{15,18});
        t1.ans(ints);

    }

    public void ans(ArrayList<int[]> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        // 防止整数对的第一个数比第二个数大，例如 2,1 的情况
        list.forEach(new Consumer<int[]>() {
            @Override
            public void accept(int[] numbers) {
                if (numbers[0] > numbers[1]) {
                    int a = numbers[0];
                    numbers[0] = numbers[1];
                    numbers[1] = a;
                }
            }
        });
        // 先按照每个整数对的第一个数排序
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        // 初始化start 和 end 为第一个整数对的两个值
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        // 开始遍历
        for (int i = 1; i < list.size(); i++) {
            int indexOne = list.get(i)[0];
            int indexTwo = list.get(i)[1];
            if (end >= indexOne) {
                // 只需要更新end
                end = indexTwo;
            }else {
                System.out.println(start + " " + end);
                // 更新start 和 end
                start = indexOne;
                end = indexTwo;
            }
            // 遍历完毕，需要再输出最后的一组答案
            if (i == list.size()-1) {
                System.out.println(start + " " + end);
            }
        }

    }
}
