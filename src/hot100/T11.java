package hot100;

public class T11 {
    public static void main(String[] args) {
        T11 t11 = new T11();
        System.out.println(t11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length-1;
        while (l < r) {
            int tmp = (r-l) * (Math.min(height[r],height[l]));
            ans = Math.max(ans,tmp);
            if (height[r] >= height[l]) {
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}
