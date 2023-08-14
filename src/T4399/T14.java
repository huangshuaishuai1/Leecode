package T4399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class T14 {
    public int countInterestingLists(char[] books, int cnt) {
        int n = books.length;
        int left = 0, right = 0;
        int interestingLists = 0;
        HashMap<Character, Integer> bookCount = new HashMap<>();

        while (right < n) {
            // 更新哈希表
            bookCount.put(books[right], bookCount.getOrDefault(books[right], 0) + 1);

            // 如果某种书籍数量超过了 cnt，移动左指针
            while (bookCount.get(books[right]) > cnt) {
                bookCount.put(books[left], bookCount.get(books[left]) - 1);
                left++;
            }

            // 计算以当前右指针位置为结尾的有趣阅读列表数量
            interestingLists += right - left + 1;

            // 移动右指针
            right++;
        }

        return interestingLists;
    }

    public static void main(String[] args) {
        T14 solution = new T14();
        char[] books = {'A', 'B', 'C', 'B'};
        int cnt = 2;
        int result = solution.countInterestingLists(books, cnt);
        System.out.println(result); // 输出：8
    }
}
