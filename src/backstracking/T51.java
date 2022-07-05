package backstracking;

import doubelpointer.T151;

import java.util.LinkedList;
import java.util.List;

public class T51 {
    public List<List<String>> solveNQueens(int n) {
        LinkedList<List<String>> ret = new LinkedList<>();
        LinkedList<Boolean[][]> used = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        // 最初的used数组是：
        Boolean[][] u1 = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                u1[i][j] = false;
            }
        }
        used.add(u1);
        backStraking(ret,strings,used,n,0);
        return ret;
    }

    private void backStraking(LinkedList<List<String>> ret, LinkedList<String> strings, LinkedList<Boolean[][]> used, int n,int line) {
        if (line == n) {
            ret.add(new LinkedList<>(strings));
            return;
        }
        Boolean[][] u = used.getLast();
        int tag = 0;
        for (int i = 0; i < n; i++) {
            if (!u[line][i]) {
                tag = 1;
                break;
            }
        }
        if (tag == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (u[line][i]) {
                continue;
            }
            strings.add(generationString(i,n));
            // 计算新的used
            Boolean[][] newU =  new Boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    newU[j][k] = u[j][k];
                }
            }
            int no = 1;
            for (int j = line+1; j < n; j++) {
                newU[j][i] = true;
                if (i - no >= 0) {
                    newU[j][i-no] = true;
                }
                if (i + no < n) {
                    newU[j][i+no] = true;
                }
                no++;
            }
            used.add(newU);
            backStraking(ret,strings,used,n,line+1);
            // 回溯
            used.removeLast();
            strings.removeLast();
        }
    }

    public String generationString(int i,int n) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(".");
        }
        sb.append("Q");
        for (int j = i; j < n-1; j++) {
            sb.append(".");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T51 t51 = new T51();
        System.out.println(t51.solveNQueens(4));
    }
}
