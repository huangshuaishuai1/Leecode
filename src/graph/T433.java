package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;

public class T433 {

    public static void main(String[] args) {
        T433 t433 = new T433();
        System.out.println(t433.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        if (!set.contains(endGene)) {
            return -1;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(startGene);

        int[] used = new int[bank.length];
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    if (used[j] == 1) {
                        continue;
                    }
                    int diff = 0;
                    for (int k = 0; k < poll.length(); k++) {
                        if (bank[j].charAt(k) != poll.charAt(k)) {
                            diff++;
                        }
                    }

                    if (diff == 1) {
                        queue.add(bank[j]);
                        if (Objects.equals(bank[j], endGene)) {
                            return ans;
                        }
                        used[j] = 1;
                    }
                }

            }

        }
        return -1;
    }

}
