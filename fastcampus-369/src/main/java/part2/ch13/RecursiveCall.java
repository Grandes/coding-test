package part2.ch13;

public class RecursiveCall {
    public static void main(String[] args) {

    }

    public int factorialFunc(int n) {
        if(n > 1) {
            return n * factorialFunc(n - 1);
        } else {
            return 1;
        }
    }
}
