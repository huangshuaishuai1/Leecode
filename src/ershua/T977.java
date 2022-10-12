package ershua;

public class T977 {
    public int[] sortedSquares(int[] nums) {
        int first = nums[0];
        int ahead = 0;
        int behind = -1;
        if (first < 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    ahead= i;
                    behind = ahead - 1;
                    break;
                }
                behind = nums.length-1;
                ahead = nums.length;
            }
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; i++) {
            if (behind >=0 && ahead <= ret.length-1) {
                if (nums[behind] * nums[behind] < nums[ahead]*nums[ahead] ) {
                    ret[i] = nums[behind] * nums[behind];
                    behind--;
                }else {
                    ret[i] = nums[ahead]*nums[ahead];
                    ahead++;
                }
            } else if (behind < 0) {
                ret[i] = nums[ahead]*nums[ahead];
                ahead++;
            } else if (ahead > ret.length-1) {
                ret[i] = nums[behind]*nums[behind];
                behind -- ;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T977 t977 = new T977();
        int [] ret = t977.sortedSquares(new int[]{-7,-1,0});
        System.out.println(ret.toString());
    }
}
