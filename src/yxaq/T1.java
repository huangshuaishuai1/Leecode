package yxaq;

public class T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.maxLuckyNum(770));
    }

    public int maxLuckyNum (int num) {

        String numStr = String.valueOf(num);
        int count = numStr.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (numStr.charAt(i) < '3') {
                StringBuilder t = new StringBuilder();
                for (int j = 0; j < count-1; j++) {
                    t.append("7");
                }
                return Integer.valueOf(new String(t));
            }else if (numStr.charAt(i) < '7') {
                sb.append("3");
            } else {
                sb.append("7");
            }

        }
        return Integer.valueOf(new String(sb));
    }
}
