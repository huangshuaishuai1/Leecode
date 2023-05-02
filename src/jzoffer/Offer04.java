package jzoffer;

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 先类似二分查找，将范围缩小到一行上
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while(i < n && j >= 0) {
            if(target == matrix[i][j]) {
                return true;
            }
            if(target > matrix[i][j]) {
                i++;
            }
            else if (target < matrix[i][j]) {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Offer04 offer04 = new Offer04();
        int[][] array = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean numberIn2DArray = offer04.findNumberIn2DArray(
                array, 20);
        System.out.println(111);
    }
}
