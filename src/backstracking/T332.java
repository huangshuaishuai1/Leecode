package backstracking;

import sun.management.MemoryUsageCompositeData;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, LinkedList<String>> ticketMap = new HashMap<>();
        LinkedList<String> ret = new LinkedList<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (ticketMap.containsKey(tickets.get(i).get(0))) {
                LinkedList<String> strings = new LinkedList<>(ticketMap.get(tickets.get(i).get(0)));
                String s = tickets.get(i).get(1);
                strings.add(s);
                Collections.sort(strings);
                ticketMap.put(tickets.get(i).get(0), strings);
            }else {
                LinkedList<String> strings = new LinkedList<>();
                strings.add(tickets.get(i).get(1));
                ticketMap.put(tickets.get(i).get(0), strings);
            }
        }
        String lastDestination = "JFK";
        ret.add(lastDestination);
        backStracking(lastDestination,ret,ticketMap,0,tickets.size());
        return ret;
    }

    private void backStracking(String lastDestination, LinkedList<String> ret, HashMap<String, LinkedList<String>> ticketMap, int startIndex, int ticketSize) {
        if (ret.size() == ticketSize+1) {
            return;
        }
        LinkedList<String> destination = ticketMap.get(lastDestination);

        if (destination == null) {
            return;
        }
        int size = destination.size();
        for (int i = 0; i < size; i++) {
            String newDestination = destination.get(i);
            ret.add(newDestination);
            destination.remove(i);
            ticketMap.put(lastDestination,destination);
            backStracking(newDestination,ret,ticketMap,startIndex,ticketSize);
            if (ret.size() == ticketSize+1) {
                return;
            }else {
                // 回溯
                String s = ret.removeLast();
                destination.add(s);
                Collections.sort(destination);
                ticketMap.put(lastDestination,destination);
            }
        }


    }


    public static void main(String[] args) {
        T332 t332 = new T332();
        List<List<String>> tickets = new LinkedList<>();
        LinkedList<String> t1 = new LinkedList<>();
        t1.add("JFK");
        t1.add("AAA");
        LinkedList<String> t2 = new LinkedList<>();
        t2.add("AAA");
        t2.add("JFK");
        LinkedList<String> t3 = new LinkedList<>();
        t3.add("JFK");
        t3.add("BBB");
        LinkedList<String> t4 = new LinkedList<>();
        t4.add("JFK");
        t4.add("CCC");
        LinkedList<String> t5 = new LinkedList<>();
        t5.add("CCC");
        t5.add("JFK");
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);
        tickets.add(t5);
        System.out.println(t332.findItinerary(tickets));

    }
}
