package ershua;

import java.util.ArrayList;
import java.util.List;

public class T113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(ret,list,root,targetSum);
        return ret;
    }

    private void helper(ArrayList<List<Integer>> ret, ArrayList<Integer> list, TreeNode node, int targetSum) {
        int nextSum = targetSum - node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (nextSum == 0) {
                ret.add(new ArrayList<>(list));
            }
            return;
        }
        if (node.left !=null) {
            helper(ret,new ArrayList<>(list),node.left,nextSum);
        }
        if (node.right != null) {
            helper(ret,new ArrayList<>(list), node.right,nextSum);
        }
    }

}
