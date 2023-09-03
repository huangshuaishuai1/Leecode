package xiaomi;


public class T1 {

    public static void main(String[] args) {
        String[] strs = {"黑","白","黑","黑","白","白"};
        int left = 0;
        int right = strs.length-1;

        while (left < right) {
            // 从前往后找白猫
            while (strs[left] != "白"){
                left++;
            }
            // 从后往前找黑猫
            while (strs[right] != "黑") {
                right--;
            }
            if (left < right) {
                String tmp = strs[left];
                strs[left] = strs[right];
                strs[right] = tmp;
            }
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]+" ");
        }
    }
}
