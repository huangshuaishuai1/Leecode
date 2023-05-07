package meituan;

import java.util.Scanner;

public class Date202356T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] leftArray = new String[n];
        String[] rightArray = new String[n];
        for (int i = 0; i < n; i++) {
            leftArray[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            rightArray[i] = scanner.next();
        }




        for (int i = 0; i < n; i++) {
            String leftOne = leftArray[i];
            String rightOne = rightArray[i];
            // 都是加
            if (leftOne.charAt(0) == '+' && rightOne.charAt(0) != '+') {
                int leftAdd = Integer.parseInt(leftOne.substring(1));
                if (rightOne.charAt(0) == '*') {
                    int rightMaster = Integer.parseInt(rightOne.substring(1));
                    if (rightMaster <= k && rightMaster > leftAdd) {
                        k += rightMaster;
                        continue;
                    }
                }
                k += leftAdd;
            }else if (rightOne.charAt(0) == '+' && leftOne.charAt(0) != '+'){
                int rightAdd = Integer.parseInt(rightOne.substring(1));
                if (leftOne.charAt(0) == '*') {
                    int leftMaster = Integer.parseInt(leftOne.substring(1));
                    if (leftMaster <= k && leftMaster > rightAdd) {
                        k += leftMaster;
                        continue;
                    }
                }
                k += rightAdd;
            }else if (rightOne.charAt(0) == '+' && leftOne.charAt(0) == '+') {
                k += Math.max(Integer.parseInt(leftOne.substring(1)),Integer.parseInt(rightOne.substring(1)));
            }else if (leftOne.charAt(0) == '*' && rightOne.charAt(0) == '*'){
                int leftMaster = Integer.parseInt(leftOne.substring(1));
                int rightMaster = Integer.parseInt(rightOne.substring(1));
                if (leftMaster <= k && rightMaster <= k) {
                    k += Math.max(leftMaster,rightMaster);
                }else if (leftMaster > k && rightMaster > k){
                    System.out.println(-1);
                    return;
                } else if (leftMaster <= k) {
                    k += leftMaster;
                }else {
                    k += rightMaster;
                }
            } else {
                int leftOperate = Operate(k,leftOne);
                int rightOperate = Operate(k,rightOne);
                k = Math.max(leftOperate,rightOperate);
            }
        }
        System.out.println(k);
    }

    private static int Operate(int k, String leftOne) {
        char op = leftOne.charAt(0);
        int z = Integer.parseInt(leftOne.substring(1));
        if (op == '-') {
            return k - z;
        }
        else  {
            return k / z;
        }
    }
}
