package elm;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] times = new String[n][3];
        for (int i = 0; i < n; i++) {

            times[i][0] = scanner.next();
            times[i][1] = scanner.next();
            times[i][2] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            String one = times[i][0];
            String two = times[i][1];
            String three = times[i][2];

            System.out.println(check1(one,two) && check1(one,three) && check2(two,three)?"NO":"YES");
        }

    }

    private static boolean check1(String one, String two) {
        String[] oneSplit = one.split(":");
        String[] twoSplit = two.split(":");
        Integer oneTime = Integer.valueOf(oneSplit[0]);
        Integer twoTime = Integer.valueOf(twoSplit[0]);

        Integer threeTime = Integer.valueOf(oneSplit[1]);
        Integer foureTime = Integer.valueOf(twoSplit[1]);
        if (oneTime == twoTime) {
            return threeTime <= foureTime;
        }
        if (oneTime < 22 && twoTime - oneTime > 2) {
            return false;
        }
        if (oneTime == 22 && twoTime > 0) {
            return false;
        }
        if (oneTime == 23 && twoTime > 1) {
            return false;
        }

        if (oneTime < 22 && twoTime - oneTime == 2) {
            if (foureTime > threeTime) {
                return false;
            }
        }
        if (oneTime == 22 && twoTime == 0) {
            if (foureTime > threeTime) {
                return false;
            }
        }

        if (oneTime == 23 && twoTime == 1) {
            if (foureTime > threeTime) {
                return false;
            }
        }
        return true;

    }

    private static boolean check2(String one, String two) {
        String[] oneSplit = one.split(":");
        String[] twoSplit = two.split(":");
        Integer oneTime = Integer.valueOf(oneSplit[0]);
        Integer twoTime = Integer.valueOf(twoSplit[0]);

        Integer threeTime = Integer.valueOf(oneSplit[1]);
        Integer foureTime = Integer.valueOf(twoSplit[1]);
        if (oneTime == twoTime) {
            if (foureTime > threeTime) {
                return false;
            }
        }
        if (oneTime == 0) {
            if (twoTime == 23 || twoTime == 22) {
                return true;
            }
            if (twoTime > 0) {
                return false;
            }
        }
        if (oneTime == 1) {
            if (twoTime == 23) {
                return true;
            }
            if (twoTime > 1) {
                return false;
            }
        }
        if (oneTime <= 23 && twoTime > oneTime) {
            return false;
        }
        if (oneTime == 23 && twoTime != 23) {
            return false;
        }

        return true;
    }
}
