package doubelpointer;

public class T344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        char temp = ' ';
        while (l < r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l ++;
            r--;
        }
    }

    public static void main(String[] args) {
        T344 t344 = new T344();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        t344.reverseString(chars);
        System.out.println(chars);
    }


}
