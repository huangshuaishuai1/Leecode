package douyin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class T {

    public static void main(String[] args) {
        T t = new T();
        int[] ints = t.twoSum(new int[]{3,2,4}, 6);
        System.out.println(ints);
    }

    public int nearestExit(int[][] maze, int[] entrance) {
        // 不是用DP，是图的遍历的题目
        int[][] dirt = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // 初始点
        queue.add(new int[]{entrance[0],entrance[1]});
        // 遍历过的地方要变为 墙
        maze[entrance[0]][entrance[1]] = 2;
        int ans = 0;
        while (!queue.isEmpty()) {

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                // 遍历每一个可以到的格子
                int[] poll = queue.poll();
                maze[poll[0]][poll[1]] = 2;
                for (int j = 0; j < 4; j++) {
                    if (poll[0] + dirt[j][0] < 0 || poll[0] + dirt[j][0] > maze.length-1
                            || poll[1] + dirt[j][1] < 0 || poll[1] + dirt[j][1] > maze[0].length-1) {
                        continue;
                    }
                    if (maze[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] == 0) {
                        if (poll[0] + dirt[j][0] == 0 || poll[0] + dirt[j][0] == maze.length-1
                                || poll[1] + dirt[j][1] == 0 || poll[1] + dirt[j][1] == maze[0].length-1) {
                            ans++;
                        }
                        queue.add(new int[]{poll[0] + dirt[j][0],poll[1] + dirt[j][1]});
                        maze[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] = 2;
                    }
                }
            }
        }

        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(nums[i],new ArrayList<Integer>());
            list.add(i);
            map.put(nums[i],list);
        }

        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                if (nums[i]* 2 == target && map.get(nums[i]).size() > 1) {
                    ArrayList<Integer> list = map.get(nums[i]);
                    ans[1] = list.get(0);
                    ans[0] = list.get(1);
                    return ans;
                }else if (nums[i]* 2 != target){
                    ArrayList<Integer> list1 = map.get(nums[i]);
                    ArrayList<Integer> list2 = map.get(target-nums[i]);

                    ans[1] = list1.get(0);
                    ans[0] = list2.get(0);
                    return ans;
                }

            }
        }
        return ans;
    }


}
