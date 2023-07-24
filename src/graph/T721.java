package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class T721 {

    public static void main(String[] args) {
        T721 t721 = new T721();
        List<String> list1 = new ArrayList<>();
        list1.add("Alex");
        list1.add("Alex5@m.co");
        list1.add("Alex4@m.co");
        list1.add("Alex0@m.co");
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        list2.add("Ethan");
        list2.add("Ethan3@m.co");
        list3.add("Ethan3@m.co");
        list3.add("johnsmith@mail.com");
        list3.add("john_newyork@mail.com");
        list4.add("Mary");
        list4.add("mary@mail.com");

        ArrayList<List<String>> account = new ArrayList<>();
        account.add(list1);
        account.add(list2);
        account.add(list3);
        account.add(list4);
        t721.accountsMerge(account);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        ArrayList<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> accountMap = new HashMap<>();

        // 初始化
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emials = accounts.get(i);
            List<String> orDefault = accountMap.getOrDefault(emials.get(0),new ArrayList<String>());
            for (int o = 1; o < emials.size(); o++) {
                String emial = emials.get(o);
                if (!orDefault.contains(emial)) {
                    orDefault.add(emial);
                }
            }
            accountMap.put(emials.get(0),orDefault);
        }
        HashMap<String, String> parents = new HashMap<>();
        accountMap.forEach((s, strings) -> {
            for (String string : strings) {
                parents.put(string,string);
            }
        });

        accounts.forEach(strings -> {
            String s1 = strings.get(1);
            for (int i = 2; i < strings.size(); i++) {
                union(parents,s1,strings.get(i));
            }
        });
        // user: (parent:List(child))
        HashMap<String, HashMap<String, List<String>>> anss = new HashMap<>();
        accountMap.forEach(new BiConsumer<String, List<String>>() {
            @Override
            public void accept(String s, List<String> strings) {
                HashMap<String, List<String>> map = anss.getOrDefault(s,new HashMap<String, List<String>>());
                for (String string : strings) {
                    String parent = findParent(parents,string);
                    List<String> orDefault = map.getOrDefault(parent, new ArrayList<>());
                    orDefault.add(string);
                    map.put(parent,orDefault);
                }
                anss.put(s,map);
            }
        });
        anss.forEach(new BiConsumer<String, HashMap<String, List<String>>>() {
            @Override
            public void accept(String s, HashMap<String, List<String>> stringListHashMap) {
                for (String s1 : stringListHashMap.keySet()) {
                    List<String> strings = stringListHashMap.get(s1);
                    strings.sort((o1, o2) -> o1.compareTo(o2));
                    strings.add(0,s);
                    ans.add(strings);
                }

            }
        });
        return ans;
    }

    public String findParent(HashMap<String,String> parents, String email) {
        if (parents.get(email) == email) {
            return email;
        }
        return findParent(parents,parents.get(email));
    }

    public void union(HashMap<String,String> parents, String a, String b) {
        String parentA = findParent(parents,a);
        String parentB = findParent(parents,b);
        if (parentA.compareTo(parentB) > 0) {
           parents.put(parents.get(parentA), parentB);
        }else {
            parents.put(parents.get(parentB), parentA);
        }
    }

}
