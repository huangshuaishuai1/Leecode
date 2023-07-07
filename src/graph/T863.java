package graph;

import tree.TreeNode;

import java.util.*;

public class T863 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        root.left = five;
        root.right = one;
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        five.left = six;
        five.right = two;
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        two.left = seven;
        two.right = four;
        TreeNode zero = new TreeNode(0);
        TreeNode nigh = new TreeNode(8);
        one.left = zero;
        one.right = nigh;

        T863 t863 = new T863();
        List<Integer> integers = t863.distanceK(root, five, 2);
        System.out.println(111);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            // 拿到它的val
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode poll = queue.poll();
                int val = poll.val;
                List<Integer> parentMap = map.getOrDefault(val, new ArrayList<>());
                if (poll.left!=null) {
                    TreeNode left = poll.left;
                    List<Integer> leftMap = map.getOrDefault(left.val, new ArrayList<>());
                    // 儿子把自己的父亲加入
                    leftMap.add(val);
                    map.put(left.val,leftMap);
                    // 父亲把儿子加入
                    parentMap.add(left.val);
                    queue.add(left);
                }
                if (poll.right!=null) {
                    TreeNode right = poll.right;
                    List<Integer> rightMap = map.getOrDefault(right.val, new ArrayList<>());
                    // 儿子把自己的父亲加入
                    rightMap.add(val);
                    map.put(right.val,rightMap);
                    // 父亲把儿子加入
                    parentMap.add(right.val);
                    queue.add(right);
                }
                map.put(val,parentMap);
            }
        }

        // 在从target开始BFS
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> queue1 = new ArrayDeque<>();
        queue1.add(target.val);
        int step = 0;
        while (!queue1.isEmpty()) {
            step++;
            int sz = queue1.size();
            for (int i = 0; i < sz; i++) {
                Integer poll = queue1.poll();
                set.add(poll);
                List<Integer> integers = map.getOrDefault(poll,new ArrayList<>());
                if (step == k) {
                    for (int j = 0; j < integers.size(); j++) {
                        if (integers.get(j) == target.val || ans.contains(integers.get(j)) || set.contains(integers.get(j))) {
                            continue;
                        }
                        ans.add(integers.get(j));
                    }

                }else {
                    for (int j = 0; j < integers.size(); j++) {
                        Integer integer = integers.get(j);
                        if (!set.contains(integer)) {
                            queue1.add(integer);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
