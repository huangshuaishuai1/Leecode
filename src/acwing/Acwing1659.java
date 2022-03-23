package acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.acwing.com/problem/content/description/1661/
public class Acwing1659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        ArrayList<Integer> midLens = new ArrayList<>();
        ArrayList<Integer> edgeLens = new ArrayList<>();
        int i = 0;
        while (i < chars.length && chars[i] != '1') {
            i++;
        }

        edgeLens.add(i);
        edgeLens.remove(new Integer(0));
        while (i < chars.length && chars[i] == '1' ) {
            int count = 0;
            int j = i + 1;
            for (j = i + 1; j < chars.length; j++) {

                if (chars[j] != '1') {
                    count++;
                }else {
                    midLens.add(count);
                    i = j;
                    break;
                }
            }
            if (j == chars.length) {
                edgeLens.add(count);
                if (midLens.size() == 0) {
                    midLens.add(1);
                }
                break;
            }
        }
        // 得到了 边距的空位长度 edgeLens, 和 中间的空位长度 midLens
        int maxEdge = Collections.max(edgeLens);
        int D = 0;
        if (midLens.size() != 0) {
            int minMid = Collections.min(midLens);
            int maxMid = Collections.max(midLens);

            if (maxEdge >= 2 * minMid + 2) {
                if (midLens.size() == 1) {
                    if (edgeLens.size() == 1) {
                        if ((maxEdge - 1) / 2 == 0) {
                            D = (maxEdge - 1) / 2;
                        }else {
                            D = (maxEdge - 1) / 2 + 1;
                        }
                    }else {
                        D = Math.min(edgeLens.get(0) , edgeLens.get(1));
                    }

                }else {
                    D = minMid + 1;
                }
            } else if (maxEdge > minMid + 1) {
                if (maxMid % 2 == 0) {
                    D = maxMid / 2;
                }else {
                    D = maxMid / 2 + 1;
                }
            } else {
                if (midLens.size() == 1) {
                    if (maxMid % 3 == 0) {
                        D = maxMid / 3;
                    }else if (maxMid % 3 == 1) {
                        D = maxMid / 3;
                    }else {
                        D = maxMid / 3 + 1;
                    }
                }else {
                    int maxOfIndex = midLens.indexOf(maxMid);
                    midLens.remove(maxOfIndex);
                    int midMid = Collections.max(midLens);
                    int D1, D2;
                    if (maxMid % 3 == 0) {
                        D1 = maxMid / 3;
                    }else if (maxMid % 3 == 1) {
                        D1 = maxMid / 3;
                    }else {
                        D1 = maxMid / 3 + 1;
                    }

                    if (midMid % 2 == 0) {
                        D2 = midMid / 2;
                    }else {
                        D2 = midMid / 2 + 1;
                    }
                    D = Math.max(D1, D2);
                }
            }
            if (midLens.size()!=1) {
                D = Math.min(D, minMid + 1);
            }

        }else {
            D = chars.length - 1;

        }
        System.out.println(D);
    }
}
