package ershua;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        List<Integer> collect = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        int[] ret = new int[k];
        for (int i = 0; i < collect.size(); i++) {
            ret[i] = collect.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        T347 t347 = new T347();
        System.out.println(t347.topKFrequent(new int[]{1}, 1));
    }
}
