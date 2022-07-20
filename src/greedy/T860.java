package greedy;

public class T860 {

    public boolean lemonadeChange(int[] bills) {
        int numFive = 0;
        int numTen = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                numFive ++;
            }else if (bills[i] == 10) {
                numTen ++;
                if (numFive <= 0) {
                    return false;
                }else {
                    numFive--;
                }
            }else {
                if (numFive == 0) {
                    return false;
                }else {
                    if (numTen != 0) {
                        numTen--;
                        numFive--;
                    }else {
                        if (numFive < 3){
                            return false;
                        }else {
                            numFive = numFive - 3;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T860 t860 = new T860();
        System.out.println(t860.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
