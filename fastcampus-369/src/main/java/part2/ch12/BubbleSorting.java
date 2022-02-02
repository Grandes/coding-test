package part2.ch12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BubbleSorting {
    public static void main(String[] args) {

        BubbleSorting fObject = new BubbleSorting();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            dataList.add((int) (Math.random() * 100));
        }

        System.out.println("before : " + dataList);
        fObject.sort(dataList);
        System.out.println("after : " + dataList);
    }

    public ArrayList<Integer> dataCount2() {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(4);
        dataList.add(2);

        if(dataList.get(0) > dataList.get(1)) {
            Collections.swap(dataList, 0, 1);
        }

        return dataList;
    }

    public ArrayList<Integer> dataCount3() {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(9);
        dataList.add(2);
        dataList.add(4);

        for(int index = 0; index < dataList.size() - 1; index++) {
            if(dataList.get(index) > dataList.get(index + 1)) {
                Collections.swap(dataList, index, index + 1);
            }
        }

        return dataList;
    }

    public  ArrayList<Integer> sort(ArrayList<Integer> dataList) {

        for(int index = 0; index < dataList.size() - 1; index++) {
            boolean swap = false;

            for(int index2 = 0; index2 < dataList.size() - 1 - index; index2++) {
                if(dataList.get(index2) > dataList.get(index2 + 1)) {
                    Collections.swap(dataList, index2, index2 + 1);
                    swap = true;
                }
            }

            if(swap == false) {
                break;
            }
        }

        return dataList;
    }
}
