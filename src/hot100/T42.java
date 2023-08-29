package hot100;

public class T42 {

    public static void main(String[] args) {
        T42 t42 = new T42();
        System.out.println(t42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            int lValue = height[left];
            int rValue = height[right];
            leftMax = Math.max(leftMax,lValue);
            rightMax = Math.max(rightMax,rValue);
            if (lValue < rValue) {
                ans+=leftMax - lValue;
                left++;
            }else {
                ans+=rightMax-rValue;
                right--;
            }
        }
        return ans;
    }
}
