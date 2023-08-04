package str;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class T648 {
    public static void main(String[] args) {
        T648 t648 = new T648();
        ArrayList<String> list = new ArrayList<>();
        list.add("catt");
        list.add("cat");
        list.add("bat");
        list.add("rat");
        System.out.println(t648.replaceWords(list, "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        List<String> list = dictionary.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }).collect(Collectors.toList());

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < dictionary.size(); j++) {
                String dic = dictionary.get(j);
                if (word.length() >= dic.length() && dic.equals(word.substring(0,dic.length()))) {
                    words[i] = dic;
                    break;
                }
            }
        }
        String join = String.join(" ", words);
        return join;

    }
}
