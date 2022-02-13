package part2.ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {

        QuickSort sObject = new QuickSort();
        System.out.println(sObject.quickSortFunc(new ArrayList<>(Arrays.asList(769, 667, 821, 186, 177))));

    }

    public ArrayList<Integer> quickSortFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for(int index = 1; index < dataList.size(); index++) {
            if(dataList.get(index) > pivot) {
                rightArr.add(dataList.get(index));
            } else {
                leftArr.add(dataList.get(index));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(this.quickSortFunc(leftArr));
        mergedArr.addAll(List.of(pivot));
        mergedArr.addAll(this.quickSortFunc(rightArr));

        return mergedArr;
    }







}
