package qianzhuihe;

public class JZOfferII013 {
    int[][] matrix;
    int[][] sum;
    public JZOfferII013(int[][] matrix) {
        this.matrix = matrix;
        int[][] sum = new int[matrix.length + 1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i+1][j+1]=sum[i][j+1] + sum[i+1][j] - sum[i][j] + matrix[i][j];
            }
        }
        this.sum = sum;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;

        return sum[row2][col2] - sum[row1-1][col2] -sum[row2][col1-1] +sum[row1-1][col1-1];
    }

    public static void main(String[] args) {
        int[][] ints = new int[5][5];
        ints[0] = new int[]{3,0,1,4,2};
        ints[1] = new int[]{5,6,3,2,1};
        ints[2] = new int[]{1,2,0,1,5};
        ints[3] = new int[]{4,1,0,1,7};
        ints[4] = new int[]{1,0,3,0,6};
        JZOfferII013 jzOfferII013 = new JZOfferII013(ints);
        System.out.println(jzOfferII013.sumRegion(2, 1, 4, 3));
    }
}
