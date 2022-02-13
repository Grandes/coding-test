package part2.ch14;

import part2.ch13.RecursiveCall;

public class DynamicProgramming {
    // 동적 계획법(Dynamic Programming) / 분할 정복(Divide and Conquer)

    public static void main(String[] args) {
        DynamicProgramming fObject = new DynamicProgramming();
        int result1 = fObject.fibonacciFunc_recursive(9);
        System.out.println(result1);

        int result2 = fObject.fibonacciFunc_dynamic(9);
        System.out.println(result2);
    }

    private int fibonacciFunc_dynamic(int i) {
        Integer[] cache = new Integer[i + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < i+1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }

        return cache[i];
    }

    private int fibonacciFunc_recursive(int i) {
        if(i == 0) {
            return 0;
        } else if(i == 1) {
            return 1;
        }

        return this.fibonacciFunc_recursive(i - 1) + this.fibonacciFunc_recursive(i - 2);
    }


}
