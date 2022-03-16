package t3;

public class t_904 {

    public int totalFruit(int[] fruits) {
        int start = 0;
        int end  = 0;
        int ens = 0;
        int temp = fruits[start];
        while (end < fruits.length) {
//            int ens1 = 0;

            if (fruits[end] != fruits[start] && temp == fruits[start]) {
                temp = fruits[end];
            }
            if (fruits[end] == fruits[start] || fruits[end] == temp) {
                end ++;
            } else {
                ens = Math.max(ens, (end - start));
//                for (int i = end; i > start ; i--) {
//                    if (fruits[i] == temp) {
//                        start = i;
//                        end = i;
//                        temp = fruits[start];
//                        break;
//                    }



//                }
                start++;
                end = start;
            }


        }
        ens = Math.max(ens, (end - start));
        return ens;
    }

    public static void main(String[] args) {
        int[] fruits = {0,1,6,6,4,4,6};
        t_904 t_904 = new t_904();
        int i = t_904.totalFruit(fruits);
        System.out.println(i);
    }
}
