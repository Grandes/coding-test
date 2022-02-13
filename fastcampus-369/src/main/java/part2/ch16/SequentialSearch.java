package part2.ch16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SequentialSearch {
    public static void main(String[] args) {
        SequentialSearch sObject = new SequentialSearch();

        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(603, 644, 603, 128, 709));

        System.out.println(sObject.searchFunc(testData, 128));


    }

    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for(int index = 0; index < dataList.size(); index++) {
            if(Objects.equals(dataList.get(index), searchItem)) {
                return index;
            }
        }
        return -1;
    }


}
