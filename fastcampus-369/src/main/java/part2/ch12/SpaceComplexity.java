package part2.ch12;

public class SpaceComplexity {
    public static void main(String[] args) {
        SpaceComplexity fObject = new SpaceComplexity();
        int result = fObject.factorialFunc2(5);

        System.out.println(result);
    }

    // 공간 복잡도 O(1)
    public int factorialFunc(int n) {
        int fac = 1;
        for (int index = 2; index < n + 1; index++) {
            fac = fac * index;
        }
        return fac;
    }

    // 공간 복잡도 O(n)
    public int factorialFunc2(int n) {
        if(n > 1) {
            return n * factorialFunc2(n - 1);
        } else {
            return 1;
        }
    }
}
