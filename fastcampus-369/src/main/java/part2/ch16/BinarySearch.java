package part2.ch16;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        // 이진탐색의 경우 먼저 정렬이 되어 있어야 한다.
        BinarySearch sObject = new BinarySearch();
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(2, 3, 8, 12, 20));
        System.out.println(sObject.searchFunc(testData, 11));

    }

    public boolean searchFunc(ArrayList<Integer> dataList, int findData) {

        if(dataList.size() == 1 && findData == dataList.get(0)) {
            return true;
        }
        if(dataList.size() == 1 && findData != dataList.get(0)) {
            return false;
        }
        if(dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if(findData == dataList.get(medium)) {
            return true;
        } else {
            if(dataList.get(medium) > findData) {
                return searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), findData);
            } else {
                return searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), findData);
            }
        }
    }

}
