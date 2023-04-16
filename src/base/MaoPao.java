package base;

public class MaoPao {

    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 2, 4, 3, 6};
        swapBubble(numbers);
        System.out.println(111);
    }

    private static void swapBubble(int[] numbers) {
        // 优化二：每轮最后一次交换的j作为下一次的交换次数
        int swaped = numbers.length-1;
        while (true) {
            int loop =  0;
            // 优化一：每轮的次数要递减
            for (int j = 0; j < swaped; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                    loop = j;
                }
            }
            swaped = loop;
            if (swaped == 0) {
                break;
            }
        }
    }

}
