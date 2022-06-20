package tree;

public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder ,0,inorder.length, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int leftIndexPre, int rightIndexPre,
                           int leftIndexIno, int rightIndexIno){
        // 递归结束
        if (leftIndexPre == rightIndexPre){
            return null;
        }
        if (leftIndexPre + 1 == rightIndexPre) {
            return new TreeNode(preorder[leftIndexPre]);
        }
        //1. 找到前序遍历的第一个值
        int first = preorder[leftIndexPre];
        TreeNode root = new TreeNode(first);
        //2. 找到这个值在中序遍历中的索引位置
        int indexOfFirst = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (first == inorder[i]) {
                indexOfFirst = i;
                break;
            }
        }
        // 3.计算左子树节点个数
        int number = indexOfFirst - leftIndexIno;


        // 递归调用左子树
        root.left = helper(preorder,inorder,leftIndexPre+1,leftIndexPre+1+number,leftIndexIno,leftIndexIno+number);
        root.right = helper(preorder,inorder,leftIndexPre+1+number,rightIndexPre,indexOfFirst+1,rightIndexIno);
        return root;
    }

    public static void main(String[] args) {
        T105 t105 = new T105();
        TreeNode treeNode = t105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
