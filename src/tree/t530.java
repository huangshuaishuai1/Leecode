package tree;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class t530 {
    LinkedList<Integer> mid = new LinkedList<>();
    public int getMinimumDifference(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        findGap(root,ret);
        ret.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return ret.get(0);
    }

    public void findGap(TreeNode root, LinkedList<Integer> ret) {
        // 左子树：

        if (root.left != null) {
            Mid(root.left);
            ret.add(root.val - mid.getLast() );
            mid.clear();
            findGap(root.left,ret);
        }
        if (root.right != null) {
            Mid(root.right);
            ret.add(mid.getFirst() - root.val);
            mid.clear();
            findGap(root.right,ret);
        }

    }
    // 中序遍历
    private void Mid(TreeNode root) {
        if (root.left!=null) {
            Mid(root.left);
        }
        mid.add(root.val);
        if (root.right!=null) {
            Mid(root.right);
        }
    }


    public static void main(String[] args) {
        t530 t530 = new t530();
        TreeNode root = new TreeNode(236);
        TreeNode t1 = new TreeNode(104);
        TreeNode t2 = new TreeNode(701);
        TreeNode t3 = new TreeNode(911);
        TreeNode t4 = new TreeNode(227);
        root.left = t1;
        root.right = t2;
        t2.right = t3;
        t1.right = t4;
        int minimumDifference = t530.getMinimumDifference(root);
        System.out.println(minimumDifference);
    }
}
