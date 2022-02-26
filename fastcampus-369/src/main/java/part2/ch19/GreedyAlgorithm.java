package part2.ch19;

import part1.ch04.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
        greedyAlgorithm.coinFunc(4720, coinList);

//        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        Integer[][] objectList = { {10, 10}, {25, 8}, {20, 10}, {30, 5}, {15, 12} };
        System.out.println("objectList: " + Arrays.deepToString(objectList));
        greedyAlgorithm.knapsackFunc(objectList, 30.0);

    }

    // 동전 문제
    public void coinFunc(Integer price, ArrayList<Integer> coinList) {
        int totalCoinCount = 0;
        int coinNum = 0;

        ArrayList<Integer> details = new ArrayList<>();

        for (Integer coin : coinList) {
            coinNum = price / coin;
            totalCoinCount += coinNum;
            price -= coinNum * coin;
            details.add(coinNum);
            System.out.println(coin + "원:" + coinNum + "개");
        }
        System.out.println("총 동전 갯수:" + totalCoinCount);
    }

    // 부분 배낭 문제(Fractional Knapsack Problem)
    public void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o2[1]/o2[0]) - (o1[1]/o1[0]);
            }
        });
        System.out.println("objectList: " + Arrays.deepToString(objectList));

        for(Integer[] objectList1 : objectList) {
            if((capacity - (double)objectList1[0] > 0 )) {
                capacity -= (double)objectList1[0];
                totalValue += (double)objectList1[1];
                System.out.println("무게: " + objectList1[0] + ",가치: " + objectList1[1]);
            } else {
                fraction = capacity / (double)objectList1[0];
                totalValue += (double)objectList1[1] * fraction;
                System.out.println("무게: " + objectList1[0] + ",가치: " + objectList1[1] +",비율: " + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치: " + totalValue);


    }






}
