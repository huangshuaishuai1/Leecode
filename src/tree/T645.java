package tree;


public class T645 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (right==left) {
            return new TreeNode(nums[left]);
        }
        if (left > right) {
            return null;
        }
        int max = max(nums,left,right);
        TreeNode root = new TreeNode(max);
        // 找到最大值的索引位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                index = i;
            }
        }
        root.left = helper(nums,left,index-1);
        root.right = helper(nums,index+1,right);
        return root;
    }

    public int max(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left+1; i <= right; i++) {
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        T645 t645 = new T645();
        TreeNode treeNode = t645.constructMaximumBinaryTree(new int[]{3, 2, 1});
        System.out.println(treeNode);
    }

}
