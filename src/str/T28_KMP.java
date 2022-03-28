package str;

public class T28_KMP {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int j = -1;
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            while(j >= 0 && haystackChar[i] != needleChar[j+1]) {
                j = next[j];
            }
            if (haystackChar[i] == needleChar[j+1]) {
                j++;
            }
            if (j == needle.length() -1 ) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static int[] getNext(String needle) {
        // 构造next数组
        int j = -1;
        int[] next = new int[needle.length()];
        next[0] = -1;
        char[] needle_chars = needle.toCharArray();
        for (int i = 1; i < needle.length(); i++) {
            while (j >= 0 && needle_chars[i] != needle_chars[j+1]) {
                j = next[j];
            }
            if (needle_chars[i] == needle_chars[j+1]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        T28_KMP t28_kmp = new T28_KMP();
        int i = t28_kmp.strStr("hello", "c");
        System.out.println(i);
    }
}
