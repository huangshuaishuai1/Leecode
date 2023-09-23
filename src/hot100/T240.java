package hot100;

public class T240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length -1;
        int j = matrix[0].length -1 ;
        for(int row = 0; row < matrix.length && row < matrix[0].length; row++) {
            if(matrix[row][row] < target) {
                continue;
            } else if(matrix[row][row] == target) {
                return true;
            } else {
                i = row ;
                j = row ;
                break;
            }
        }
        for(int row = i; row >= 0; row--) {
            if(matrix[row][j] == target) {
                return true;
            } else if (matrix[row][j] < target){
                break;
            }
        }

        for(int col = j; col >= 0; col--) {
            if(matrix[i][col] == target) {
                return true;
            } else if (matrix[i][col] < target){
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T240 t240 = new T240();
        System.out.println(t240.searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}, 15));
    }
}
