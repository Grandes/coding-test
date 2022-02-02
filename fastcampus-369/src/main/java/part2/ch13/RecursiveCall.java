package part2.ch13;

import part2.ch12.SpaceComplexity;

import java.util.ArrayList;

public class RecursiveCall {
    public static void main(String[] args) {
        RecursiveCall fObject = new RecursiveCall();
        int result = fObject.factorialFunc2(5);

        System.out.println(result);

        ArrayList<Integer> testData = new ArrayList<>();
        for(int data = 0; data < 10; data++) {
            testData.add(data);
        }
        System.out.println(testData);

        System.out.println(factorialFunc3(testData));
        System.out.println(factorialFunc3_1(testData));
        System.out.println(fObject.factorialFunc4(5));
    }

    public int factorialFunc(int n) {
        if(n > 1) {
            return n * factorialFunc(n - 1);
        } else {
            return 1;
        }
    }

    public int factorialFunc2(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * factorialFunc2(n - 1);
    }

    // 배열에서 subList를 이용하여 재귀함수
    public static int factorialFunc3(ArrayList<Integer> dataList) {
        if(dataList.size() <= 0) {
            return 0;
        }
        return dataList.get(0) + factorialFunc3(new ArrayList<>(dataList.subList(1, dataList.size())));
    }

    public static int factorialFunc3_1(ArrayList<Integer> dataList) {
        if(dataList.size() <= 0) {
            return 0;
        }
        int temp = dataList.get(0);
        dataList.remove(0);
        return temp + factorialFunc3_1(dataList);
    }

    public int factorialFunc4(int data) {
        if(data == 1) {
            return 1;
        } else if(data == 2) {
            return 2;
        } else if(data == 3) {
            return 4;
        }
        return this.factorialFunc4(data - 1) + this.factorialFunc4(data - 2) + this.factorialFunc4(data - 3);
    }
}
