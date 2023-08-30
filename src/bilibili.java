import java.util.Scanner;

public class bilibili {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int ans = 0;
        int l = a[0];
        int r = a[1];
        int i = 2;
        while (i < n){
            int min = Math.min(l,r);
            ans+=min;
            l -= min;
            r -= min;
            if (l == r) {
                r = a[i];
                i++;
                if (i < n) {
                    l = a[i];
                    i++;
                }
            }
            else if (l > 0) {
                r = a[i++];
            }else if (r > 0) {
                l = a[i++];
            }
        }
        int tmp = Math.max(l,r);
        ans+= tmp;
        System.out.println(ans);
    }
}
