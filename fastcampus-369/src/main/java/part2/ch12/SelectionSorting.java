package part2.ch12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SelectionSorting {
    public static void main(String[] args) {
        SelectionSorting fObject = new SelectionSorting();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            dataList.add((int) (Math.random() * 100));
        }

        System.out.println("before : " + dataList);
        fObject.sort(dataList);
        System.out.println("after : " + dataList);
    }

    public  ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest;
        for(int stand = 0; stand < dataList.size() - 1; stand++) {
            lowest = stand;
            for(int index = stand + 1; index < dataList.size(); index++) {
                if(dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }

}
