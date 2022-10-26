package ershua;

public class T151 {

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length() && s.charAt(i) != ' ') {
            sb.append(s.charAt(i));
            i++;
        }
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            sb.insert(0,' ');
            int offset = 0;
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.insert(offset,s.charAt(i));
                offset++;
                i++;
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        T151 t151 = new T151();
        System.out.println(t151.reverseWords("aaa"));
    }
}
