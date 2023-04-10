package niuke;

import java.util.ArrayList;

public class Ty5 {


    public static void main(String[] args) {
        Ty5 ty5 = new Ty5();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(50);
        list.add(4);
        System.out.println(ty5.getSubarrayNum(list, 2));
    }
    static long n = 0;
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
        long mod = (long) Math.pow(10,x);
        for (int i = 0; i < a.size(); i++) {
            long pro = 1;
            for (int j = i; j < a.size(); j++) {
                if (a.get(j) % mod == 0) {
                    n+=(a.size()-j);
                    break;
                }
                pro *= a.get(j);
                pro %= mod;
                if (pro == 0) {
                    n+=(a.size()-j);
                    break;
                }
            }
        }
        return (int) (n % 1000000007);
    }

//    public static void helper(ArrayList<Integer> a, int x,int startIndex, long pro) {
//        long mod = (long) Math.pow(10,x);
//        if ( pro % mod == 0) {
//            n++;
//        }
//        for (int i = startIndex; i < a.size(); i++) {
//            Integer num = a.get(i);
//            pro *= num;
//            helper(a,x,i+1,pro);
//            // 回溯
//            pro /= num;
//        }
//    }



}
