package part2.ch15;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort sObject = new MergeSort();
//        sObject.splitFunc(new ArrayList<Integer>(Arrays.asList(852, 136, 308, 46, 94)));
        sObject.mergeSplitFunc(new ArrayList<Integer>(Arrays.asList(852, 23, 111, 136, 308, 46, 94)));

        System.out.println(sObject.mergeSplitFunc(new ArrayList<Integer>(Arrays.asList(852, 23, 111, 136, 308, 46, 94))));
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));  // 0 부터 medium - 1 인덱스 번호까지 해당 배열 아이템을 서브 배열로 추출
        rightArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;
        while(leftArr.size() > leftPoint && rightArr.size() > rightPoint) {
            if(leftArr.get(leftPoint) > rightArr.get(rightPoint)) {
                mergeList.add(rightArr.get(rightPoint));
                rightPoint++;
            } else {
                mergeList.add(leftArr.get(leftPoint));
                leftPoint++;
            }
        }

        if(leftArr.size() > leftPoint) {
            while(leftArr.size() > leftPoint) {
                mergeList.add(leftArr.get(leftPoint));
                leftPoint++;
            }
        } else {
            while(rightArr.size() > rightPoint) {
                mergeList.add(rightArr.get(rightPoint));
                rightPoint++;
            }
        }

        return mergeList;
    }


    public void splitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = new ArrayList<Integer>(dataList.subList(0, medium));  // 0 부터 medium - 1 인덱스 번호까지 해당 배열 아이템을 서브 배열로 추출
        rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));

        System.out.print(String.valueOf(leftArr));
        System.out.print(String.valueOf(rightArr));
    }







}
