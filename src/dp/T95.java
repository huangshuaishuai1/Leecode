package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T95 {
    public static void main(String[] args) {
        T95 t95 = new T95();
        List<TreeNode> treeNodes = t95.generateTrees(3);
        System.out.println(111);
    }

    public List<TreeNode> generateTrees(int n) {
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        ArrayList<TreeNode> zero = new ArrayList<>();
        if (n == 0)
            return zero;
        zero.add(null);
        map.put(0,zero);
        ArrayList<TreeNode> one = new ArrayList<>();
        TreeNode treeNode = new TreeNode(1);
        one.add(treeNode);
        map.put(1,one);
        for (int i = 2; i <= n; i++) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<TreeNode> left = map.get(j);
                List<TreeNode> right = map.get(i-1-j);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(j+1);
                        root.left = l;
                        root.right = generateDp(r,j+1);
                        treeNodes.add(root);
                    }
                }
            }
            map.put(i,treeNodes);
        }
        return map.get(n);
    }

    private TreeNode generateDp(TreeNode root, int offset) {

        if (root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.val + offset);
        node.left = generateDp(root.left,offset);
        node.right = generateDp(root.right,offset);
        return node;

    }
}
