package part2.ch12;

import java.util.ArrayList;
import java.util.Collections;

public class InsertSorting {
    public static void main(String[] args) {
        InsertSorting fObject = new InsertSorting();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            dataList.add((int) (Math.random() * 100));
        }

        System.out.println("before : " + dataList);
        fObject.sort(dataList);
        System.out.println("after : " + dataList);
    }

    public  ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for(int index = 0; index < dataList.size() - 1; index++) {
            for(int index2 = index + 1; index2 > 0; index2--) {
                if(dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }

        return dataList;
    }
}
