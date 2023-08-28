package T4399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nowHave = new int[14];
        int[] count = new int[10];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            nowHave[i] = scanner.nextInt();
            count[nowHave[i]]++;
        }
        // 遍历增加每种数字进入nowHava
        for (int i = 1; i < 10; i++) {
            if (count[i] >= 3) {
                continue;
            }
            nowHave[13] = i;
            count[i]++;
            // 遍历能作为雀头的数字
            for (int j = 1; j < 10; j++) {
                if (count[j] < 2) {
                    continue;
                }
                // 将雀头从数组中移除
                int[] tmp = new int[12];
                int len = 0;
                for (int k = 1; k < 10; k++) {
                    int sz = count[k];
                    if (k == j) {
                        sz-=2;
                    }
                    for (int l = 0; l < sz; l++) {
                        tmp[len++] = k;
                    }
                }
                if (isValid(tmp,0,tmp.length-1)) {
                    arrayList.add(i);
                    break;
                }
            }
            count[i]--;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
    
    public static boolean isValid(int[] nowHave, int start, int end) {
        if ((end - start + 1) % 3 != 0) {
            return false;
        }
        if (end - start == 2) {
            return (nowHave[start] == nowHave[start+1] && nowHave[start] == nowHave[start+2]) ||
                    (nowHave[start] + 1 == nowHave[start+1] && nowHave[start+1]+1 == nowHave[start+2]);
        }
        
        // 尝试从左边取3
        if (nowHave[start] == nowHave[start+1] && nowHave[start] == nowHave[start+2]) {
            return isValid(nowHave, start+3,end);
        }
        for (int i = start+1; i <= end; i++) {
            for (int j = i+1; j <= end ; j++) {
                if (nowHave[start] + 1 == nowHave[i] && nowHave[i] + 1 == nowHave[j]) {
                    int[] tmp = new int[end - start - 2];
                    int index = 0;
                    for (int k = start; k <= end; k++) {
                        if (k!= start && k!= i && k != j) {
                            tmp[index++] = nowHave[k];
                        }
                    }
                    if (isValid(tmp,0,tmp.length-1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
