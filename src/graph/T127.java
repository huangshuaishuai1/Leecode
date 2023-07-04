package graph;

import java.util.*;

public class T127 {
    public static void main(String[] args) {
        T127 t127 = new T127();
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

        System.out.println(t127.ladderLength("hit", "cog", list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        int ans = 1;
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int used[] = new int[wordList.size()];
        while (!queue.isEmpty()) {
            int sz = queue.size();
            ans ++;
            for (int i = 0; i < sz; i++) {
                String poll = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (used[j] == 1) {
                        continue;
                    }
                    int diff = 0;
                    String word = wordList.get(j);
                    for (int k = 0; k < word.length(); k++) {
                        if (word.charAt(k) != poll.charAt(k)) {
                            diff++;
                        }
                    }
                    if (diff == 1) {
                        if (Objects.equals(word,endWord)) {
                            return ans;
                        }
                        queue.add(word);
                        used[j] = 1;
                    }
                }
            }
        }
        return 0;
    }
}
