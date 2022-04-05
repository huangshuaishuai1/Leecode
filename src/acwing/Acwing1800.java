package acwing;

import java.util.*;

public class Acwing1800 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Bessie",0);
        map.put("Elsie",0);
        map.put("Daisy",0);
        map.put("Gertie",0);
        map.put("Annabelle",0);
        map.put("Maggie",0);
        map.put("Henrietta",0);
        HashSet<String> nameSet = new HashSet<>();
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            String name = scanner.next();
            int milk = scanner.nextInt();
            nameSet.add(name);
            map.put(name,map.get(name)+milk);
        }
        HashMap<Integer, HashSet<String>> map1 = new HashMap<>();
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String name = (String)entry.getKey();
            Integer milk = (Integer)entry.getValue();
            if (map1.containsKey(milk)) {
                HashSet<String> strings = map1.get(milk);
                strings.add(name);
                map1.put(milk,strings);
            }else {
                HashSet<String> strings = new HashSet<>();
                strings.add(name);
                map1.put(milk,strings);
            }
        }
        ArrayList<Integer> milks = new ArrayList<>(map1.keySet());
        Collections.sort(milks);
        if (map1.get(milks.get(0)).size() == 7) {
            System.out.println("Tie");
        }else  if (map1.get(milks.get(1)).size() > 1) {
            System.out.println("Tie");
        }else {
            ArrayList<String> ret = new ArrayList<>(map1.get(milks.get(1)));
            System.out.println(ret.get(0));
        }
    }
}
