package dp;

import java.util.ArrayList;
import java.util.List;

public class T894 {
    public static void main(String[] args) {
    }
    public List<TreeNode> allPossibleFBT(int n) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (n % 2 == 0) {
            return list;
        }

        if (n == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        for (int left = 1,  right = n - 2; left < n; left++,  right--) {
            List<TreeNode> leftSubtrees = allPossibleFBT(left);
            List<TreeNode> rightSubtrees = allPossibleFBT(right);
            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    TreeNode root = new TreeNode(0,leftSubtree,rightSubtree);
                    list.add(root);
                }
            }
        }
        return list;
    }

}
