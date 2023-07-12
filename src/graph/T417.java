package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class T417 {

    public static void main(String[] args) {
        T417 t417 = new T417();
        int[][] height = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = t417.pacificAtlantic(height);
        System.out.println(111);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] dirt = {{-1,0},{1,0},{0,-1},{0,1}};
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                queue.add(list);
                int tag0 = 0;
                int tag1 = 0;
                int[][] used = new int[heights.length][heights[0].length];
                used[i][j] = 1;
                while (!queue.isEmpty()) {
                    int sz = queue.size();
                    for (int k = 0; k < sz; k++) {
                        List<Integer> poll = queue.poll();
                        int m = poll.get(0);
                        int n = poll.get(1);
                        for (int l = 0; l < 4; l++) {
                            if (tag0 == 1 && tag1 == 1) {
                                ArrayList<Integer> list1 = new ArrayList<>();
                                list1.add(i);
                                list1.add(j);
                                ans.add(list1);
                                break;
                            }
                            if (m + dirt[l][0] < 0) {
                                tag0 = 1;
                                continue;
                            }
                            if (m + dirt[l][0] >= heights.length) {
                                tag1 = 1;
                                continue;
                            }
                            if (n + dirt[l][1] < 0) {
                                tag0 = 1;
                                continue;
                            }
                            if (n + dirt[l][1] >= heights[0].length) {
                                tag1 = 1;
                                continue;
                            }
                            if (heights[m][n] >= heights[m + dirt[l][0]][n + dirt[l][1]] && used[m + dirt[l][0]][n + dirt[l][1]] == 0) {
                                ArrayList<Integer> list1 = new ArrayList<>();
                                list1.add(m + dirt[l][0]);
                                list1.add(n + dirt[l][1]);
                                used[m + dirt[l][0]][n + dirt[l][1]] = 1;
                                queue.add(list1);
                                if (ans.contains(list1)){
                                    ArrayList<Integer> list2 = new ArrayList<>();
                                    list2.add(i);
                                    list2.add(j);
                                    ans.add(list2);
                                    tag0 = 1;
                                    tag1 = 1;
                                    break;
                                }
                            }
                        }
                        if (tag0 == 1 && tag1 == 1) {
                            ArrayList<Integer> list1 = new ArrayList<>();
                            list1.add(i);
                            list1.add(j);
                            if (!ans.contains(list1)) {
                                ans.add(list1);
                            }
                            break;
                        }
                    }
                    if (tag0 == 1 && tag1 == 1) {
                        break;
                    }
                }

            }
        }
        return ans;
    }
}
