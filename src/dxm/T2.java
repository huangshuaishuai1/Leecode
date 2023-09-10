package dxm;

import java.util.*;

public class T2 {

    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        ArrayList<Integer>[] arrayLists = new ArrayList[50001];
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            int tmp = scanner.nextInt();
            arrayLists[tmp].add(i);
        }
        for (int i = 1; i <= n; i++) {
            int tmp = scanner.nextInt();
            hashMap.put(i,tmp);
        }
        System.out.println(dfs(hashMap,1,arrayLists));
    }

    static int dfs(HashMap<Integer,Integer> hashMap,int root,ArrayList<Integer>[] arrayLists) {
        int mod = 1000000007;
        if (arrayLists[root].size() == 0) {
            return 1;
        }
        long l = dfs(hashMap,arrayLists[root].get(0),arrayLists);
        long r = dfs(hashMap,arrayLists[root].get(1),arrayLists);
        if (hashMap.get(root) == 1) {
            return (int)(l+r) % mod;
        }
        return (int)(l%mod * r%mod) %mod;
    }
}
