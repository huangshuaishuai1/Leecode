package acwing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Acwing1725 {

    public static void main(String[] args) {
        char[][] play = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String next = scanner.nextLine();
            char[] playArray = next.toCharArray();
            for (int j = 0; j < 3; j++) {
                play[i][j] = playArray[j];
            }
        }
        // 只需要遍历每一行
        int countSinglePlay = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (play[i][0] == play[i][1] && play[i][0] == play[i][2]) {
                set.add(play[i][0]);
            }
        }
        countSinglePlay = set.size();
        if (countSinglePlay == 0) {
            for (int i = 0; i < 3; i++) {
                if (play[0][i] == play[1][i] && play[0][i] == play[2][i]){
                    set.add(play[0][i]);
                }
            }
        }
        countSinglePlay = set.size();
        if (countSinglePlay == 0) {
            if (play[0][0] == play[1][1] && play[0][0] == play[2][2]){
                set.add(play[0][0]);
            }
            if (play[0][2] == play[1][1] && play[0][2] == play[2][0]) {
                set.add(play[0][0]);
            }
        }
        countSinglePlay = set.size();
        System.out.println(countSinglePlay);
        HashSet<HashSet<Character>> set2 = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (play[i][0] == play[i][1] || play[i][0] == play[i][2] || play[i][1] == play[i][2]) {
                HashSet<Character> tempSet = new HashSet<>();
                tempSet.add(play[i][0]);
                tempSet.add(play[i][1]);
                tempSet.add(play[i][2]);
                if (tempSet.size() == 2) {
                    set2.add(tempSet);
                }
            }
            if (play[0][i] == play[1][i] || play[0][i] == play[2][i] || play[1][i] == play[2][i]) {
                HashSet<Character> tempSet = new HashSet<>();
                tempSet.add(play[0][i]);
                tempSet.add(play[1][i]);
                tempSet.add(play[2][i]);
                if (tempSet.size() == 2) {
                    set2.add(tempSet);
                }
            }
        }
        if (play[0][0] == play[1][1] || play[0][0] == play[2][2] || play[1][1] == play[2][2]) {
            HashSet<Character> tempSet = new HashSet<>();
            tempSet.add(play[0][0]);
            tempSet.add(play[1][1]);
            tempSet.add(play[2][2]);
            if (tempSet.size() == 2) {
                set2.add(tempSet);
            }
        }
        if (play[0][2] == play[1][1] || play[0][2] == play[2][0] || play[1][1] == play[2][0]) {
            HashSet<Character> tempSet = new HashSet<>();
            tempSet.add(play[0][2]);
            tempSet.add(play[1][1]);
            tempSet.add(play[2][0]);
            if (tempSet.size() == 2) {
                set2.add(tempSet);
            }
        }

        System.out.println(set2.size());
    }
}
