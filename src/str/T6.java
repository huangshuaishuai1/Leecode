package str;

public class T6 {
    public static void main(String[] args) {
        T6 t6 = new T6();
        String paypalishiring = t6.convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int a = numRows-1;
        a = 2*a;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows-1) {
                int j = i;
                while (j < s.length()){
                    stringBuilder.append(s.charAt(j));
                    j+=a;
                }
            }else {
                int j = i;
                while (j < s.length()) {
                    stringBuilder.append(s.charAt(j));
                    j+=(a-i*2);
                    if (j < s.length()) {
                        stringBuilder.append(s.charAt(j));
                    }else {
                        break;
                    }
                    j+=2*i;
                }
            }
        }
        return new String(stringBuilder);
    }
}
