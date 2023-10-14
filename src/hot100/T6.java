package hot100;

public class T6 {

    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 2*numRows - 2;
        for(int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                int j = i;
                while(j < len) {
                    sb.append(s.charAt(j));
                    j+=count;
                }
            } else {
                int l = count - 2 * i;
                int r = 2 * i;
                int j = i;
                while(j < len) {
                    sb.append(s.charAt(j));
                    j+=l;
                    if(j < len) {
                        sb.append(s.charAt(j));
                    }
                    j += r;
                }
            }
        }
        return new String(sb);
    }

}
