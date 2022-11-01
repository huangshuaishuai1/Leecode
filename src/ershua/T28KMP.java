package ershua;

/*
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。

 */
public class T28KMP {
    public int strStr(String haystack, String needle) {
        // 先计算模式串的next数组
        int[] next = new int[needle.length()];
        next[0] = 0;
        int j  = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                 j++;
            }
            next[i] = j;
        }

        // 开始和文本串进行匹配
        j = 0 ;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() +1 ;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        T28KMP t28KMP = new T28KMP();
        System.out.println(t28KMP.strStr("aaa", "aa"));
    }
}
