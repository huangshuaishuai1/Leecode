package ershua;

public class T344 {

    public void reverseString(char[] s) {
        int front = 0;
        int behind = s.length - 1;
        while (front < behind) {
            char tmp = s[front];
            s[front] = s[behind];
            s[behind] = tmp;
            front++;
            behind--;
        }
    }

}
