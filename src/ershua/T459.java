package ershua;

public class T459 {

    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i <= chars.length / 2; i++) {
            if (chars.length % i != 0) {
                continue;
            }
            int times = chars.length / i;
            int j = 0;
            for (j = 0; j < i; j++) {
                char a = chars[j];
                int k = 1;
                for (k = 1; k < times; k++) {
                    if (a != chars[j + k * i]) {
                        break;
                    }
                }
                if (k != times) {
                    break;
                }
            }if (j == i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T459 t459 = new T459();
        System.out.println(t459.repeatedSubstringPattern("ababcababc"));
    }
}
