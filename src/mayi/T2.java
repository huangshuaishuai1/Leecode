package mayi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class node{

    public String name;
    public long cnt;
    public node(String name, long cnt) {
        this.name = name;
        this.cnt = cnt;
    }
}

public class T2 {

    public static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        Map<String, Long> mp = new TreeMap<>();
        HashMap<String, Integer> cnt = new HashMap<>();
        HashMap<String, List<node>> v = new HashMap<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            String name1 = str[0];
            mp.put(name1, Long.parseLong(str[1]));
            cnt.put(name1, 0);
            str = br.readLine().split(" ");

            int m = Integer.parseInt(str[0]);
            for (int j = 0; j < m; j++) {
                str = br.readLine().split(" ");
                String name = str[0];
                int val = Integer.parseInt(str[1]);
                if (!v.containsKey(name)) v.put(name, new ArrayList<>());
                v.get(name).add(new node(name1, val));
                int tmp = cnt.get(name1) + val;
                cnt.put(name1, tmp);
            }
        }
        Queue<String> q = new LinkedList<>();
        for (String s : cnt.keySet()) {
            if (cnt.get(s) == 0) {
                q.add(s);
            }
        }
        while(!q.isEmpty()) {
            String s = q.poll();
            List<node> tmp = v.get(s);
            if (tmp == null) continue;
            for (int i = 0; i < tmp.size(); i++) {
                String name = tmp.get(i).name;
                long t = tmp.get(i).cnt;
                cnt.put(name, (int) (cnt.get(name)-t));
                mp.put(name, (mp.get(name)+t*mp.get(s))%mod);
                if (cnt.get(name) == 0)
                {
                    q.add(name);
                }
            }
        }
        for (String s : mp.keySet()) {
            System.out.println(s + " " + (mp.get(s))%mod);
        }
    }
}