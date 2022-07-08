package dp;

public class T509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n ==1 ){
            return  1;
        }
        return fib(n-1)  + fib(n-2);
    }

    public static void main(String[] args) {
        T509 t509 = new T509();
        System.out.println(t509.fib(3));
    }
}
