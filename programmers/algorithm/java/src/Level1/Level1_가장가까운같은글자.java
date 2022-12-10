package Level1;

import java.util.Arrays;
import java.util.HashMap;

public class Level1_가장가까운같은글자 {
    public static void main(String[] args) {
        // result : [-1, -1, -1, 2, 2, 2]
//        String s = "banana";
        // result : [-1, -1, 1, -1, -1, -1]
//        String s = "foobar";
        String s = "aaabbbccc";

        int[] solution = solution(s);
        System.out.println("solution : " + Arrays.toString(solution));
    }

    public static int[] solution(String s) {
        String[] sArray = s.split("");
        int[] answer = new int[sArray.length];

        // 각 글자별 가장 가까운 글자의 배열 숫자
        HashMap<String, Integer> sArrayMap = new HashMap<>();
        HashMap<String, Integer> sArrayCount = new HashMap<>();
        for(int i = 0; i < sArray.length; i++) {
            if(sArrayCount.getOrDefault(sArray[i], 0) == 0) {
                answer[i] = -1;
            } else {

                answer[i] = Math.abs(i - sArrayMap.get(sArray[i]));
            }
            sArrayMap.put(sArray[i], i);
            sArrayCount.put(sArray[i], sArrayCount.getOrDefault(sArray[i], 0) + 1);
        }





        return answer;
    }
}
