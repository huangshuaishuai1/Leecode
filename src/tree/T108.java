package tree;

public class T108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return generetor(nums,0,nums.length-1);
    }

    private TreeNode generetor(int[] nums, int start, int end) {
        if (start == end) {
            TreeNode treeNode = new TreeNode(nums[start]);
            return treeNode;
        }
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = generetor(nums,start,mid-1);
        treeNode.right = generetor(nums,mid+1,end);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] ints = {-10, -3, 0, 5, 9,};

        T108 t108 = new T108();
        TreeNode treeNode = t108.sortedArrayToBST(ints);

        System.out.println(
                treeNode
        );
    }
}
