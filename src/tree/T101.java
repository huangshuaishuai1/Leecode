package tree;

import java.util.*;

public class T101 {
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        List<List<Integer>> leftList = levelOrder(root.left);
        List<List<Integer>> rightList = levelOrder(root.right);
        if(leftList.size() != rightList.size()) {
            return false;
        }
        for(int i = 0; i < leftList.size(); i++) {
            List<Integer> left = leftList.get(i);
            List<Integer> right = rightList.get(i);
            Collections.reverse(right);
            if(left.size() != right.size()) {
                return false;
            }
            for(int j = 0; j < left.size(); j++) {
                if(left.get(j) != right.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (root != null){
            queue.add(root);
        }
        else{
            return lists;
        }
        while (queue.size() >0) {
            ArrayList<Integer> items = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode poll = queue.poll();
                if (poll.val == 101) {
                    items.add(101);
                }else {
                    items.add(poll.val);
                    if (poll.left!=null){
                        queue.add(poll.left);
                    }else {
                        queue.add(new TreeNode(101));
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }else {
                        queue.add(new TreeNode(101));
                    }
                }
                len --;
            }
            lists.add(items);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        t2.right = t4;
        root.left = t2;
        root.right=t3;
        t3.right = t5;
        T101 t101 = new T101();
        boolean symmetric = t101.isSymmetric(root);
        System.out.println(symmetric);
    }
}
